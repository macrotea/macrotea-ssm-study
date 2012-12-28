package com.mtea.ssm;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractTestCase extends AbstractJUnit4SpringContextTests {
	
/*
 * @BeforeTransaction
 * @AfterTransaction
 */
	
}