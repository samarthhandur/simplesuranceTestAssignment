package com.simplesurance.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.simplesurance.pages.PaymentConfirmationPage;

/**
 * Empty Class for initialising the test suite by using @RunWith annotation
 * @param SuiteClass name
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
	LoginTest.class,
	CreateCertificateTest.class,
	PaymentTest.class,
	CertificateListTest.class,
	CreateSubAgentListTest.class
})

public class TestSuiteClass {

}
