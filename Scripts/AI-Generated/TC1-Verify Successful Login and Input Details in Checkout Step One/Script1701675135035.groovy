import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page home'

WebUI.navigateToUrl(GlobalVariable.application_domain + '')

'step 2: Login at Page home --> navigate to Page checkout-step-one html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 3: Navigate to Page checkout-step-one html'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/checkout-step-one.html')

'step 4: Login at Page checkout-step-one html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/checkout-step-one.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 5: At Page checkout-step-one html input on input firstname'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_firstname')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.setText(testObj, var_1_input_firstname)

'step 6: At Page checkout-step-one html input on input lastname'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_lastname')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.setText(testObj, var_2_input_lastname)

'step 7: At Page checkout-step-one html input on input postalcode'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_postalcode')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.setText(testObj, var_3_input_postalcode)

'step 8: At Page checkout-step-one html click on input continue'

testObj = findTestObject('AI-Generated/Page_checkout-step-one_html/input_continue')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout-step-one.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 9: Login at Page checkout-step-one html --> navigate to Page checkout-step-two html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/checkout-step-one.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 10: Add visual checkpoint at Page checkout-step-two html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Verify Successful Login and Input Details in Checkout Step One_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
