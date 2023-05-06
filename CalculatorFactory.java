package com.liupin.evaluation.core;

import com.liupin.evaluation.component.constant.EvaluationRuleCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CalculatorFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Calculator getCalculator(String code) {
        String beanName = EvaluationRuleCode.getBeanName(code);
        return StringUtils.isBlank(beanName) ? null : applicationContext.getBean(beanName, Calculator.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
