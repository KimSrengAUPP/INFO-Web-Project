package com.example.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
public class AppController {
	@Autowired
	private BookingService bookingservice;
	@Autowired
	private ContactService contactservice;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/")
    public String redirectIndex() {
    	return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
    	Contact contact = new Contact();
		model.addAttribute("contact", contact);
    	return "index";
    }
    
    @RequestMapping("Kompot")
    public String kompot() {
        return "Kompot"; 
    }

    @RequestMapping("Battambang")
    public String battambang() {
        return "Battambang"; 
    }

    @RequestMapping("Kirirom")
    public String kirirom() {
        return "Kirirom"; 
    }

    @RequestMapping("KompongThom")
    public String kompongthom() {
        return "KompongThom"; 
    }

    @RequestMapping("Mondulkiri")
    public String mondulkiri() {
        return "Mondulkiri"; 
    }

    @RequestMapping("PhnomPenh")
    public String phnompenh() {
        return "PhnomPenh"; 
    }

    @RequestMapping("PreahVihear")
    public String preahvihear() {
        return "PreahVihear"; 
    }

    @RequestMapping("SiemReap")
    public String siemreap() {
        return "SiemReap"; 
    }

    @RequestMapping("Sihanoukville")
    public String sihanoukville() {
        return "Sihanoukville"; 
    }
    
    @RequestMapping("admin")
    public String admin() {
    	return "admin";
    }
    
    @RequestMapping("booking")
    public String booking(Model model) {
    	Booking booking = new Booking();
		model.addAttribute("booking", booking);
    	return "booking";
    }
    
    @PostMapping("savebooking")
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
		bookingservice.save(booking);
		return "redirect:/index";
	}

    @PostMapping("savecontact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
		contactservice.save(contact);
		return "redirect:/index";
	}
    
    @RequestMapping("admin/booking_list")
    public String listBookings(Model model) {
    	List<Booking> bookings = bookingservice.listAll();
    	model.addAttribute("bookings", bookings);
    	return "booking_list";
    }
    
    @RequestMapping("admin/contact_list")
    public String listContacts(Model model) {
    	List<Contact> contacts = contactservice.listAll();
    	model.addAttribute("contacts", contacts);
    	return "contact_list";
    }
    
    @RequestMapping("admin/booking_list/booking_update/{id}")
    public String showUpdateBooking(@PathVariable(name = "id") Long id, Model model) {
    	Booking booking = bookingservice.get(id);
    	model.addAttribute("booking", booking);
    	
    	return "booking_update";
    }
    
    @PostMapping("admin/updatebooking")
    public String updateBooking(@ModelAttribute ("booking") Booking booking) {
    	bookingservice.save(booking);
    	return "redirect:/admin/booking_list";
    }
    
    @RequestMapping("admin/contact_list/contact_update/{id}")
    public String showUpdateContact(@PathVariable(name = "id") Long id, Model model) {
    	Contact contact = contactservice.get(id);
    	model.addAttribute("contact", contact);
    	
    	return "contact_update";
    }
    
    @PostMapping("admin/updatecontact")
    public String updateContact(@ModelAttribute ("contact") Contact contact) {
    	contactservice.save(contact);
    	return "redirect:/admin/contact_list";
    }
    

    
}
