package org.seckill.personal.web;

import java.util.List;

import org.seckill.personal.dto.Exposer;
import org.seckill.personal.dto.SeckillExecution;
import org.seckill.personal.dto.SeckillResult;
import org.seckill.personal.entity.Seckill;
import org.seckill.personal.enums.SeckillStateEnum;
import org.seckill.personal.exception.RepeatSeckillException;
import org.seckill.personal.exception.SeckillCloseException;
import org.seckill.personal.exception.SeckillException;
import org.seckill.personal.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill")
public class SeckillController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SeckillService service;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model)
    {
        logger.info("enter list", getClass());
        List<Seckill> list = service.getSeckillList();
        model.addAttribute("list", list);
        logger.info("exit list", getClass());
        return "list";
    }
    
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model)
    {
        if (null == seckillId)
        {
            return "forward:/seckill/list";
        }
        
        Seckill seckill = service.getById(seckillId);
        if (null == seckill)
        {
            return "redirect:/seckill/list";
        }
        
        model.addAttribute("seckill", seckill);
        return "detail";
    }
    
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {
        "application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId)
    {
        SeckillResult<Exposer> result = null;
        try
        {
            Exposer exposer = service.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        
        return result;
    }
    
    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {
        "application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
        @PathVariable("md5") String md5, @CookieValue(value = "killPhone", required = false) Long userPhone)
    {
        if (null == userPhone)
        {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        
        try
        {
            //SeckillExecution seckillExecution = service.executeSeckill(seckillId, userPhone, md5);
            SeckillExecution seckillExecution = service.executeSeckillProcedure(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true, seckillExecution);
        }
        catch (RepeatSeckillException e)
        {
            return new SeckillResult<SeckillExecution>(true,
                new SeckillExecution(seckillId, SeckillStateEnum.REPAET_KILL));
        }
        catch (SeckillCloseException e)
        {
            return new SeckillResult<SeckillExecution>(true, new SeckillExecution(seckillId, SeckillStateEnum.END));
        }
        catch (SeckillException e)
        {
            logger.error(e.getMessage(), e);
            return new SeckillResult<SeckillExecution>(true,
                new SeckillExecution(seckillId, SeckillStateEnum.INNER_ERROR));
        }
    }
    
    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time()
    {
        return new SeckillResult<Long>(true, System.currentTimeMillis());
    }
}
