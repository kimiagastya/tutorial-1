package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private List<Product> products;
    private List<Order> orders;

    @BeforeEach
    void setUp() {

        // Setup products
        this.products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);


        // Setup orders
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products, 1708560000L, "Safira Sudrajat");
        Order order2 = new Order("93652556-012a-4c07-b546-54eb1396d79b", this.products, 1708570000L, "Bambang Bambang");
        this.orders = new ArrayList<Order>();
        this.orders.add(order1);
        this.orders.add(order2);
    }


    // Voucher Code
    @Test
    void testCreatePaymentSameOrders() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertSame(this.orders.getFirst(), payment.getOrder());
    }

    @Test
    void testCreatePaymentVoucherSuccess(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }
    @Test
    void testCreatePaymentVoucherRejectedNot16Characters(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC56782");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
    @Test
    void testCreatePaymentVoucherRejectedNotStartedWithESHOP(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESSHOP1234ABC567");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
    @Test
    void testCreatePaymentVoucherRejectedNotContain8NumericalCharacters(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC567D");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherRejectedNoVocuherCode(){
        Map<String, String> paymentData = new HashMap<String, String>();
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }


    @Test
    void testSetStatusPaymentVoucherSuccess(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC567D");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getOrder().getStatus());
    }
    @Test
    void testSetStatusPaymentVoucherRejected(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC567D");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        payment.setStatus("REJECTED");
        assertEquals("FAILED", payment.getOrder().getStatus());
    }


    @Test
    void testCreateOrderInvalidStatus() {
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("voucherCode", "ESHOP1234ABC567D");
        Payment payment = new PaymentVoucher("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertThrows (IllegalArgumentException.class, () -> {
            payment.setStatus("Test");
        });
    }



    // Cash on Delivery
    @Test
    void testCreatePaymentCashOnDeliverySuccess(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("address", "Bahrain");
        paymentData.put("deliveryFee", "10000");
        Payment payment = new PaymentCashOnDelivery("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }
    @Test
    void testCreatePaymentCashOnDeliveryRejectedMissingAddress(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("deliveryFee", "10000");
        Payment payment = new PaymentCashOnDelivery("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
    @Test
    void testCreatePaymentCashOnDeliveryRejectedMissingDeliveryFee(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("address", "Bahrain");
        Payment payment = new PaymentCashOnDelivery("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testSetStatusPaymentCashOnDeliverySuccess(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("address", "Bahrain");
        paymentData.put("deliveryFee", "10000");
        Payment payment = new PaymentCashOnDelivery("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getOrder().getStatus());
    }
    @Test
    void testSetStatusPaymentCashOnDeliveryRejected(){
        Map<String, String> paymentData = new HashMap<String, String>();
        paymentData.put("address", "Bahrain");
        paymentData.put("deliveryFee", "10000");
        Payment payment = new PaymentCashOnDelivery("6c93d3e2-b009-46ba-9d15-f03d85adc2de", this.orders.getFirst(), paymentData);

        payment.setStatus("REJECTED");
        assertEquals("FAILED", payment.getOrder().getStatus());
    }
}