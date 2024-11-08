package com.omi.clientservice.controller;


import com.omi.clientservice.ClientServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class ClientServiceController {

	private static final Logger log = (Logger) LoggerFactory.getLogger(ClientServiceController.class);

	@Autowired
	private RestTemplate  template;

	@GetMapping("/payment/{price}")
	public String invokePaymentServices(@PathVariable int price){
		log.info("ClientServiceController => invokePaymentServices => : price"+price);

		String url="http://PAYMENT-SERVICES/payment-provider/pay/"+price;
		log.info("ClientServiceController => invokePaymentServices => : url"+url);

		return template.getForObject(url,String.class);
	}


}
