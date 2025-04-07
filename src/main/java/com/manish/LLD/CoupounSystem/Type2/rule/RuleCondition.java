package com.manish.LLD.CoupounSystem.Type2.rule;

import com.manish.LLD.CoupounSystem.Type2.model.ConditionOperator;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RuleCondition {
    private String fieldName;
    private ConditionOperator operator;
    private Object value;

    public boolean evaluate(Object context) {
        // Implementation depends on fieldName and operator
        // Use reflection to get field value from context and compare
        return true; // simplified
    }
}
