package com.singlestone.petstore.orderentry;

import com.singlestone.petstore.orderentry.valueobject.OrderSummaryVO;
import com.singlestone.petstore.orderentry.valueobject.OrderVO;
import com.singlestone.petstore.orderentry.valueobject.ProductQuantityVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderEntryApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testOrderEntryServices() {
        OrderVO orderVO = createOrderVo("1234");
        orderVO.getItems().add(createQuatityVO(10, "0a207870"));
        restTemplate.postForLocation("/order/entry", orderVO);
        ResponseEntity<OrderSummaryVO> summaryResp =  restTemplate.getForEntity("/order/entry/summary/1234", OrderSummaryVO.class);
        Assert.assertEquals(summaryResp.getStatusCode(), HttpStatus.OK);
        OrderSummaryVO summaryVO = summaryResp.getBody();
        Assert.assertNotNull(summaryVO);
        Assert.assertEquals(orderVO.getCustomerId(), summaryVO.getCustomerId());
        Assert.assertEquals(10, summaryVO.getItemsCount());
        //10 * 9.95 = 99.50
        Assert.assertEquals("99.50", summaryVO.getGrandTotal());
        orderVO.getItems().add(createQuatityVO(10, "8ed0e6f7")) ;
        restTemplate.postForLocation("/order/entry", orderVO);
        summaryResp =  restTemplate.getForEntity("/order/entry/summary/1234", OrderSummaryVO.class);
        summaryVO = summaryResp.getBody();
        Assert.assertEquals(20, summaryVO.getItemsCount());
        //(10 * 9.95) + (10 * 124.95) = 1349.00
        Assert.assertEquals("1349.00", summaryVO.getGrandTotal());
        orderVO.getItems().add(createQuatityVO(10, "c0258525")) ;
        restTemplate.postForLocation("/order/entry", orderVO);
        summaryResp =  restTemplate.getForEntity("/order/entry/summary/1234", OrderSummaryVO.class);
        summaryVO = summaryResp.getBody();
        Assert.assertEquals(30, summaryVO.getItemsCount());
        //(10 * 9.95) + (10 * 124.95) + (10 * 3.50) = 1384.00
        Assert.assertEquals("1384.00", summaryVO.getGrandTotal());

    }

    private OrderVO createOrderVo(String cusId){
        OrderVO orderVO = new OrderVO();
        orderVO.setCustomerId(cusId);
        List<ProductQuantityVO> productQuantityVOS = new ArrayList<>();
        orderVO.setItems(productQuantityVOS);
        return orderVO;
    }

    private ProductQuantityVO createQuatityVO(int count, String prdId){
        ProductQuantityVO productQuantityVO = new ProductQuantityVO();
        productQuantityVO.setProductId(prdId);
        productQuantityVO.setQuantity(count);
        return  productQuantityVO;
    }

}
