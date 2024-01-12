package com.example.demo.UserController;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.UserEntity.User;
import com.example.demo.UserService.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController 
{
	@Autowired
	UserService us;
@GetMapping("pay")
public String pay()
{
	return"pay";
}

@SuppressWarnings("finally")
@PostMapping("/createOrder")
@ResponseBody
public String createOrder(HttpSession session) {

	int  amount  = 5000;
	Order order=null;
	try {
		RazorpayClient razorpay=new RazorpayClient("rzp_test_1Hc0Bdd8Pof2VC", "8qwpV1BA04oOtEM1wVCOcI4G");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amount*100); // amount in the smallest currency unit
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt", "order_rcptid_11");

		order = razorpay.orders.create(orderRequest);

		String mail =  (String) session.getAttribute("email");

		User u = us.getUser(mail);
		u.setPremium(true);
		us.updateUser(u);

	} catch (RazorpayException e) {
		e.printStackTrace();
	}
	finally {
		return order.toString();
	}
}	
}
