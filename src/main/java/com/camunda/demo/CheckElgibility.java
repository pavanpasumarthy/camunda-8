package com.camunda.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.model.bpmn.impl.instance.zeebe.ZeebeUserTaskFormImpl;
import io.camunda.zeebe.model.bpmn.instance.zeebe.ZeebeUserTaskForm;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;

@Component
public class CheckElgibility {

	@JobWorker(type = "checkeligibility", autoComplete = true)
	public Map<String, Object> loanElgibilityChecker(final ActivatedJob ac, final JobClient jc) {
		
		System.out.print("size of the elements received " + ac.getVariablesAsMap().entrySet().size());
		int salary = Integer.parseInt(ac.getVariable("salary").toString());
		int loanRequired = Integer.parseInt(ac.getVariable("loanRequired").toString());
		int creditScore = Integer.parseInt(ac.getVariable("creditScore").toString());

		System.out.println(salary + " " + loanRequired + " " + creditScore + " " + (salary * 134));
		String overideByManager = ac.getVariable("overideByManager").toString();
		Map<String, Object> result = new Hashtable<>();
		if (creditScore <= 740) {
			System.out.println("iam executing 1");
			result.put("isCibilScoreCheck", "false");
			result.put("isLoanApproved", "loan Rejected Due to Bad CreditScore");
		} else if (loanRequired > (salary * 134) && overideByManager.equals("false")) {
			System.out.println("iam executing 2");
			result.put("isCibilScoreCheck", "true");
			result.put("isLoanApproved", "Greater");
		} else {
			System.out.println("iam executing 3");

			result.put("isCibilScoreCheck", "true");
			result.put("isLoanApproved", "elgible");
			result.put("loanAssignedBy", new ApprovedAt());
		}

		return result;
	}

}
