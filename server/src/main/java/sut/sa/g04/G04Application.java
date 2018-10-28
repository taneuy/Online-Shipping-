package sut.sa.g04;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

@SpringBootApplication
public class G04Application {

	public static void main(String[] args) {
		SpringApplication.run(G04Application.class, args);
	}

	@Bean
	ApplicationRunner init(CustomerRepository customerRepository,
						   MessengerServiceRepository messengerServiceRepository,
						   MessengerAreaRepository messengerAreaRepository,
						   MessengerOrderRepository messengerOrderRepository,
						   ConvenienceProductRepository convenienceProductRepository,
						   ConvenienceOrderRepository convenienceOrderRepository,
						   ConvenienceSetProductRepository convenienceSetProductRepository,
						   PostalOrderRepository postalOrderRepository,
						   PostalAmountRepository postalAmountRepository,
						   PostalCategoryRepository postalCategoryRepository,
						   TaxiAreaRepository taxiAreaRepository,
						   TaxiCarServiceRepository taxiCarServiceRepository,
						   TaxiOrderRepository taxiOrderRepository,
						   BikePaymentRepository bikePaymentRepository,
						   BikeAreaRepository bikeAreaRepository,
						   BikeOrderRepository bikeOrderRepository,
						   FoodOrderRepository foodOrderRepository,
						   FoodBasketRepository foodBasketRepository,
						   FoodMenuRepository foodMenuRepository) {
		return args -> {

			Customer customer1 = new Customer();
			customer1.setName("Kan");
			customer1.setPhone("0801111111");
			customer1.setEmail("kangame2009@gmail.com");
			customer1.setAddress("499 ถนนวรจักร แขวง ป้อมปราบ เขต ป้อมปราบศัตรูพ่าย กรุงเทพมหานคร 10100");
			customer1.setUsername("kan");
			customer1.setPassword("1234");
			customerRepository.save(customer1);

			Customer customer2 = new Customer();
			customer2.setName("Pimpun");
			customer2.setPhone("0802222222");
			customer2.setEmail("thommanakan@hotmail.com");
			customer2.setAddress("300 ถนน ซอย รัชมงคลประสาธน์ แขวง ปากคลองภาษีเจริญ เขต ภาษีเจริญ กรุงเทพมหานคร 10160");
			customer2.setUsername("pim");
			customer2.setPassword("2345");
			customerRepository.save(customer2);

			Customer customer3 = new Customer();
			customer3.setName("Rachataporn");
			customer3.setPhone("0803333333");
			customer3.setEmail("stepme693@gmail.com");
			customer3.setAddress("665 ถนน บำรุงเมือง แขวง คลองมหานาค เขต ป้อมปราบศัตรูพ่าย กรุงเทพมหานคร 10100");
			customer3.setUsername("pon");
			customer3.setPassword("3456");
			customerRepository.save(customer3);

			Customer customer4 = new Customer();
			customer4.setName("Supanniga");
			customer4.setPhone("0805555555");
			customer4.setEmail("spng.oga@gmail.com");
			customer4.setAddress("593 29-39 ซอยสุขุมวิท 33/1 แขวงคลองเตยเหนือ เขตวัฒนา กรุงเทพมหานคร 10110");
			customer4.setUsername("mint");
			customer4.setPassword("4567");
			customerRepository.save(customer4);

			Customer customer5 = new Customer();
			customer5.setName("Sasiprapha");
			customer5.setPhone("0813515767");
			customer5.setEmail("bas22739@gmail.com");
			customer5.setAddress("28 สามเสน แขวง วัดสามพระยา เขต พระนคร กรุงเทพมหานคร 10200");
			customer5.setUsername("bas");
			customer5.setPassword("5678");
			customerRepository.save(customer5);

			Customer customer6 = new Customer();
			customer6.setName("Panjawan");
			customer6.setPhone("0855777555");
			customer6.setEmail("tanneuy@gmail.com");
			customer6.setAddress("26 ถนนสุทธิสารวินิจฉัย แขวง สามเสนนอก เขต ห้วยขวาง กรุงเทพมหานคร 10310");
			customer6.setUsername("neuy");
			customer6.setPassword("6789");
			customerRepository.save(customer6);

			ConvenienceProduct product1 = new ConvenienceProduct();
			product1.setProductName("ข้าวกล่องผัดกระเพราหมู");
			convenienceProductRepository.save(product1);
			ConvenienceProduct product2 = new ConvenienceProduct();
			product2.setProductName("ข้าวกล่องผัดกระเพราไก่");
			convenienceProductRepository.save(product2);
			ConvenienceProduct product3 = new ConvenienceProduct();
			product3.setProductName("ข้าวไข่เจียวกุ้ง");
			convenienceProductRepository.save(product3);
			ConvenienceProduct product4 = new ConvenienceProduct();
			product4.setProductName("ข้าวผัดปู");
			convenienceProductRepository.save(product4);
			ConvenienceProduct product5 = new ConvenienceProduct();
			product5.setProductName("โจ๊กหมู");
			convenienceProductRepository.save(product5);
			ConvenienceProduct product6 = new ConvenienceProduct();
			product6.setProductName("แซนวิช แฮมชีส พร้อมทาน");
			convenienceProductRepository.save(product6);
			ConvenienceProduct product7 = new ConvenienceProduct();
			product7.setProductName("ขนมจีบกุ้ง");
			convenienceProductRepository.save(product7);
			ConvenienceProduct product8 = new ConvenienceProduct();
			product8.setProductName("ซาลาเปาหมูสับ");
			convenienceProductRepository.save(product8);
			ConvenienceProduct product9 = new ConvenienceProduct();
			product9.setProductName("อกไก่นุ่มพร้อมทาน");
			convenienceProductRepository.save(product9);
			ConvenienceProduct product10 = new ConvenienceProduct();
			product10.setProductName("ไข่ไก่ออนเซ็นพร้อมทาน");
			convenienceProductRepository.save(product10);

			ConvenienceOrder newOrder1 = new ConvenienceOrder();
			Customer c1 = customerRepository.findByName("Sasiprapha");
			newOrder1.setAdder(c1);
			convenienceOrderRepository.save(newOrder1);

			ConvenienceOrder newOrder2 = new ConvenienceOrder();
			Customer c2 = customerRepository.findByName("Supanniga");
			newOrder2.setAdder(c2);
			convenienceOrderRepository.save(newOrder2);



			ConvenienceProduct cp1 = convenienceProductRepository.findByProductName("ข้าวกล่องผัดกระเพราหมู");
			ConvenienceProduct cp2 = convenienceProductRepository.findByProductName("ข้าวกล่องผัดกระเพราไก่");
			ConvenienceProduct cp3 = convenienceProductRepository.findByProductName("ข้าวไข่เจียวกุ้ง");
			// ConvenienceProduct cp4 = convenienceProductRepository.findByProductName("ข้าวผัดปู");
			ConvenienceProduct cp5 = convenienceProductRepository.findByProductName("โจ๊กหมู");
			// ConvenienceProduct cp6 = convenienceProductRepository.findByProductName("แซนวิช แฮมชีส พร้อมทาน");
			ConvenienceProduct cp7 = convenienceProductRepository.findByProductName("ขนมจีบกุ้ง");
			// ConvenienceProduct cp8 = convenienceProductRepository.findByProductName("ซาลาเปาหมูสับ");
			ConvenienceProduct cp9 = convenienceProductRepository.findByProductName("อกไก่นุ่มพร้อมทาน");
			// ConvenienceProduct cp10 = convenienceProductRepository.findByProductName("ไข่ไก่ออนเซ็นพร้อมทาน");

			ConvenienceOrder co1 = convenienceOrderRepository.findByOrderId(1L);
			ConvenienceSetProduct csp1 = new ConvenienceSetProduct();
			csp1.setOrderId(1L);
			csp1.setProduct(cp1);
			convenienceSetProductRepository.save(csp1);
			co1.getListProduct().add(csp1);

			ConvenienceSetProduct csp2 = new ConvenienceSetProduct();
			csp2.setOrderId(1L);
			csp2.setProduct(cp2);
			convenienceSetProductRepository.save(csp2);
			co1.getListProduct().add(csp2);

			ConvenienceSetProduct csp3 = new ConvenienceSetProduct();
			csp3.setOrderId(1L);
			csp3.setProduct(cp3);
			convenienceSetProductRepository.save(csp3);
			co1.getListProduct().add(csp3);

			convenienceOrderRepository.save(co1);

			ConvenienceOrder co2 = convenienceOrderRepository.findByOrderId(2L);
			ConvenienceSetProduct csp4 = new ConvenienceSetProduct();
			csp4.setOrderId(2L);
			csp4.setProduct(cp9);
			convenienceSetProductRepository.save(csp4);
			co2.getListProduct().add(csp4);

			ConvenienceSetProduct csp5 = new ConvenienceSetProduct();
			csp5.setOrderId(2L);
			csp5.setProduct(cp7);
			convenienceSetProductRepository.save(csp5);
			co2.getListProduct().add(csp5);

			ConvenienceSetProduct csp6 = new ConvenienceSetProduct();
			csp6.setOrderId(2L);
			csp6.setProduct(cp5);
			convenienceSetProductRepository.save(csp6);
			co2.getListProduct().add(csp6);

			convenienceOrderRepository.save(co2);

			MessengerService service1 = new MessengerService();
			service1.setServiceType("One-way");
			service1.setServicePrice(5L);
			messengerServiceRepository.save(service1);

			MessengerService service2 = new MessengerService();
			service2.setServiceType("Round-trip");
			service2.setServicePrice(10L);
			messengerServiceRepository.save(service2);

			MessengerArea area1 = new MessengerArea();
			area1.setAreaType("Bangkok");
			area1.setAreaPrice(40L);
			messengerAreaRepository.save(area1);

			MessengerArea area2 = new MessengerArea();
			area2.setAreaType("Metropolitan");
			area2.setAreaPrice(50L);
			messengerAreaRepository.save(area2);

			MessengerOrder order1 = new MessengerOrder();
			order1.setPaidCustomer(customer1);
			order1.setPaidService(service1);
			order1.setPaidArea(area1);
			order1.setReceiverName("นายสมชาย ใจดี");
			order1.setReceiverPhone("0803334444");
			order1.setReceiverAddress("1110/5 ซอยสุขุมวิท 46/1 ถนนสุขุมวิท แขวงพระโขนง เขตคลองเตย กรุงเทพมหานคร 10110");
			order1.setNote("ห้ามโยน");
			order1.setTotalPrice(45L);
			messengerOrderRepository.save(order1);

			PostalAmount amount1 = new PostalAmount();
			amount1.setBox("1");
			amount1.setMin(1);
			amount1.setMax(1);
			postalAmountRepository.save(amount1);

			PostalAmount amount2 = new PostalAmount();
			amount2.setBox("2-5");
			amount2.setMin(2);
			amount2.setMax(5);
			postalAmountRepository.save(amount2);

			PostalAmount amount3 = new PostalAmount();
			amount3.setBox("6-10");
			amount3.setMin(6);
			amount3.setMax(10);
			postalAmountRepository.save(amount3);

			PostalAmount amount4 = new PostalAmount();
			amount4.setBox("11-20");
			amount4.setMin(11);
			amount4.setMax(20);
			postalAmountRepository.save(amount4);

			PostalAmount amount5 = new PostalAmount();
			amount5.setBox("21-30");
			amount5.setMin(21);
			amount5.setMax(30);
			postalAmountRepository.save(amount5);

			PostalAmount amount6 = new PostalAmount();
			amount6.setBox("31-40");
			amount6.setMin(31);
			amount6.setMax(40);
			postalAmountRepository.save(amount6);

			PostalAmount amount7 = new PostalAmount();
			amount7.setBox("41-50");
			amount7.setMin(41);
			amount7.setMax(50);
			postalAmountRepository.save(amount7);

			PostalCategory category1 = new PostalCategory();
			category1.setCategory("REGISTER");
			postalCategoryRepository.save(category1);

			PostalCategory category2 = new PostalCategory();
			category2.setCategory("EMS");
			postalCategoryRepository.save(category2);

			PostalOrder postalOrder1 = new PostalOrder();
			postalOrder1.setCustomerorder(customer2);
			postalOrder1.setCategory(category1);
			postalOrder1.setAmount(amount4);
			postalOrder1.setOrderDate(new Date());
			postalOrderRepository.save(postalOrder1);

			TaxiArea taxiArea1 = new TaxiArea();
			taxiArea1.setAreaType("ในตัวเมื่อง");
			taxiArea1.setAreaPrice(50L);
			taxiAreaRepository.save(taxiArea1);

			TaxiArea taxiArea2 = new TaxiArea();
			taxiArea2.setAreaType("ต่างจังหวัด");
			taxiArea2.setAreaPrice(100L);
			taxiAreaRepository.save(taxiArea2);

			TaxiCarService taxicarService1 = new TaxiCarService();
			taxicarService1.setCarType("4 seat");
			taxicarService1.setCarPrice(40L);
			taxiCarServiceRepository.save(taxicarService1);

			TaxiCarService taxicarService2 = new TaxiCarService();
			taxicarService2.setCarType("7 seat");
			taxicarService2.setCarPrice(70L);
			taxiCarServiceRepository.save(taxicarService2);

			TaxiOrder taxiOrder1 = new TaxiOrder();
			taxiOrder1.setCustomer(customer1);
			taxiOrder1.setTaxiArea(taxiArea1);
			taxiOrder1.setLocation1("Central Pinkao");
			taxiOrder1.setLocation2("Chatuchak");
			taxiOrder1.setTaxicarService(taxicarService1);
			taxiOrder1.setNote("รอตรงป้ายรถเมล์ ถ้าถึงแล้วโทรบอกด้วยน่ะค่ะ");
			taxiOrder1.setTotalPrice(taxiArea1.getAreaPrice()+taxicarService1.getCarPrice());
			taxiOrderRepository.save(taxiOrder1);

			TaxiOrder taxiOrder2 = new TaxiOrder();
			taxiOrder2.setCustomer(customer2);
			taxiOrder2.setTaxiArea(taxiArea2);
			taxiOrder2.setLocation1("Central Pinkao");
			taxiOrder2.setLocation2("Chatuchak");
			taxiOrder2.setTaxicarService(taxicarService2);
			taxiOrder2.setNote("รอตรงป้ายรถเมล์ ถ้าถึงแล้วโทรบอกด้วยน่ะค่ะ");
			taxiOrder2.setTotalPrice(taxiArea2.getAreaPrice()+taxicarService2.getCarPrice());
			taxiOrderRepository.save(taxiOrder2);

			BikeArea bikearea1 = new BikeArea();
			bikearea1.setAreaType("สยาม - อนุเสาวรีย์");
			bikearea1.setAreaPrice(30L);
			bikeAreaRepository.save(bikearea1);
			BikeArea bikearea2 = new BikeArea();
			bikearea2.setAreaType("สยาม - สนามหลวง");
			bikearea2.setAreaPrice(90L);
			bikeAreaRepository.save(bikearea2);
			BikeArea bikearea3 = new BikeArea();
			bikearea3.setAreaType("อนุเสาวรีย์ - สนามหลวง");
			bikearea3.setAreaPrice(60L);
			bikeAreaRepository.save(bikearea3);

			BikePayment payment1 = new BikePayment();
			payment1.setPaymentType("Cash");
			bikePaymentRepository.save(payment1);
			BikePayment payment2 = new BikePayment();
			payment2.setPaymentType("Promtpay");
			bikePaymentRepository.save(payment2);
			BikePayment payment3 = new BikePayment();
			payment3.setPaymentType("E-Banking");
			bikePaymentRepository.save(payment3);

			BikeOrder bikeOrder1 = new BikeOrder();
			bikeOrder1.setCustomer(customer2);
			bikeOrder1.setBikeArea(bikearea2);
			bikeOrder1.setBikePayment(payment1);
			bikeOrder1.setPickLocation("หน้าสยามวัน");
			bikeOrder1.setDropLocation("หน้าสนามหลวง");
			bikeOrder1.setTotalPrice(20+ bikearea2.getAreaPrice());
			bikeOrderRepository.save(bikeOrder1);

			//------------------------------------MENU--------------------------------------------------------------------------

			FoodMenu menu1 = new FoodMenu();
			String code1 = "01.th.jpg";
			menu1.setCode(code1);
			menu1.setUrl("https://www.img.live/images/2018/10/27/" + code1);
			menu1.setFoodMenuName("Pasta Arrabbiata with Nut-Free Vegan Parmesan");
			menu1.setFoodMenuPrice(129L);
			foodMenuRepository.save(menu1);


			FoodMenu menu2 = new FoodMenu();
			String code2 = "02.th.jpg";
			menu2.setCode(code2);
			menu2.setUrl("https://www.img.live/images/2018/10/27/" + code2);
			menu2.setFoodMenuName("Olive and Artichoke Pasta Salad");
			menu2.setFoodMenuPrice(89L);
			foodMenuRepository.save(menu2);

			FoodMenu menu3 = new FoodMenu();
			String code3 = "03.th.jpg";
			menu3.setCode(code3);
			menu3.setUrl("https://www.img.live/images/2018/10/27/" + code3);
			menu3.setFoodMenuName("Roasted Tomato and Basil Pasta");
			menu3.setFoodMenuPrice(129L);
			foodMenuRepository.save(menu3);

			FoodMenu menu4 = new FoodMenu();
			String code4 = "04.th.jpg";
			menu4.setCode(code4);
			menu4.setUrl("https://www.img.live/images/2018/10/27/" + code4);
			menu4.setFoodMenuName("Summer Zucchini Pasta");
			menu4.setFoodMenuPrice(89L);
			foodMenuRepository.save(menu4);

			FoodMenu menu5 = new FoodMenu();
			String code5 = "05.th.jpg";
			menu5.setCode(code5);
			menu5.setUrl("https://www.img.live/images/2018/10/27/" + code5);
			menu5.setFoodMenuName("Pan-Seared Ribeye Steak with Blue Cheese Butter");
			menu5.setFoodMenuPrice(119L);
			foodMenuRepository.save(menu5);

			FoodMenu menu6 = new FoodMenu();
			String code6 = "06.th.png";
			menu6.setCode(code6);
			menu6.setUrl("https://www.img.live/images/2018/10/27/" + code6);
			menu6.setFoodMenuName("Grilled Dorade Sea Bream with Grilled Lemon and Salsa of Almonds and Olives");
			menu6.setFoodMenuPrice(89L);
			foodMenuRepository.save(menu6);

			FoodMenu menu7 = new FoodMenu();
			String code7 = "07.th.jpg";
			menu7.setCode(code7);
			menu7.setUrl("https://www.img.live/images/2018/10/27/" + code7);
			menu7.setFoodMenuName("Thyme Roasted Lamb with Sweet Potato and Oregano Salsa Verde");
			menu7.setFoodMenuPrice(199L);
			foodMenuRepository.save(menu7);

			FoodMenu menu8 = new FoodMenu();
			String code8 = "08.th.jpg";
			menu8.setCode(code8);
			menu8.setUrl("https://www.img.live/images/2018/10/27/" + code8);
			menu8.setFoodMenuName("Tomahawk Steak");
			menu8.setFoodMenuPrice(215L);
			foodMenuRepository.save(menu8);

			FoodMenu menu9 = new FoodMenu();
			String code9 = "09.th.jpg";
			menu9.setCode(code9);
			menu9.setUrl("https://www.img.live/images/2018/10/27/" + code9);
			menu9.setFoodMenuName("Balsamic Mushroom and Goat Cheese Pizza");
			menu9.setFoodMenuPrice(199L);
			foodMenuRepository.save(menu9);

			FoodMenu menu10 = new FoodMenu();
			String code10 = "10.th.jpg";
			menu10.setCode(code10);
			menu10.setUrl("https://www.img.live/images/2018/10/27/" + code10);
			menu10.setFoodMenuName("Mushroom Pesto Pizza");
			menu10.setFoodMenuPrice(135L);
			foodMenuRepository.save(menu10);

//--------------------------------------FoodDeliveryOrder--------------------------------------------------------------


			FoodMenu m1 = foodMenuRepository.findByFoodMenuName("Pasta Arrabbiata with Nut-Free Vegan Parmesan");
			FoodMenu m2 = foodMenuRepository.findByFoodMenuName("Olive and Artichoke Pasta Salad");
			FoodMenu m3 = foodMenuRepository.findByFoodMenuName("Roasted Tomato and Basil Pasta");
			FoodMenu m4 = foodMenuRepository.findByFoodMenuName("Summer Zucchini Pasta");

			FoodMenu m5 = foodMenuRepository.findByFoodMenuName("Pan-Seared Ribeye Steak with Blue Cheese Butter");
			FoodMenu m6 = foodMenuRepository.findByFoodMenuName("Grilled Dorade Sea Bream with Grilled Lemon and Salsa of Almonds and Olives");
			FoodMenu m7 = foodMenuRepository.findByFoodMenuName("Thyme Roasted Lamb with Sweet Potato and Oregano Salsa Verde");
			FoodMenu m8 = foodMenuRepository.findByFoodMenuName("Tomahawk Steak");

			FoodMenu m9 = foodMenuRepository.findByFoodMenuName("Balsamic Mushroom and Goat Cheese Pizza");
			FoodMenu m10 = foodMenuRepository.findByFoodMenuName("Mushroom Pesto Pizza");


			FoodOrder newFoodOrder1 = new FoodOrder();
			Customer cus1 = customerRepository.findByName("Pimpun");
			newFoodOrder1.setAdder(cus1);
			//newFoodOrder1.setTotalPrice(1180L);
			foodOrderRepository.save(newFoodOrder1);

			FoodOrder FoodOrder1 = foodOrderRepository.findByOrderId(1L);
			FoodBasket basket1 = new FoodBasket();
			basket1.setOrderID(1L);
			basket1.setFoodmenu(m1);
			foodBasketRepository.save(basket1);
			FoodOrder1.getListMenu().add(basket1);

			//FoodDeliveryOrder order1 = foodDeliveryOrderRepository.findByOrderId(1L);
			FoodBasket basket2 = new FoodBasket();
			basket2.setOrderID(1L);
			basket2.setFoodmenu(m3);
			foodBasketRepository.save(basket2);
			FoodOrder1.getListMenu().add(basket2);

			foodOrderRepository.save(FoodOrder1);



			FoodOrder newFoodOrder2 = new FoodOrder();
			Customer cus2 = customerRepository.findByName("Supanniga");
			newFoodOrder2.setAdder(cus2);
			//newFoodOrder2.setTotalPrice(1180L);
			foodOrderRepository.save(newFoodOrder2);

			FoodOrder FoodOrder2 = foodOrderRepository.findByOrderId(2L);
			FoodBasket basket3 = new FoodBasket();
			basket3.setOrderID(2L);
			basket3.setFoodmenu(m3);
			foodBasketRepository.save(basket3);
			FoodOrder2.getListMenu().add(basket3);

			foodOrderRepository.save(FoodOrder2);


			customerRepository.findAll().forEach(System.out::println);
			messengerServiceRepository.findAll().forEach(System.out::println);
			messengerAreaRepository.findAll().forEach(System.out::println);
			messengerOrderRepository.findAll().forEach(System.out::println);
			postalAmountRepository.findAll().forEach(System.out::println);
			postalCategoryRepository.findAll().forEach(System.out::println);
			postalOrderRepository.findAll().forEach(System.out::println);
			taxiAreaRepository.findAll().forEach(System.out::println);
			taxiCarServiceRepository.findAll().forEach(System.out::println);
			taxiOrderRepository.findAll().forEach(System.out::println);
			bikePaymentRepository.findAll().forEach(System.out::println);
			bikeAreaRepository.findAll().forEach(System.out::println);
			bikeOrderRepository.findAll().forEach(System.out::println);
			foodMenuRepository.findAll().forEach(System.out::println);
			foodOrderRepository.findAll().forEach(System.out::println);
			foodBasketRepository.findAll().forEach(System.out::println);


		};

	}

}
