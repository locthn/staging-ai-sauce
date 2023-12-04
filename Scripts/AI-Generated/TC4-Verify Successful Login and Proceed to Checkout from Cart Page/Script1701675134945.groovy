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

'step 4: Login at Page checkout-step-one html --> navigate to Page cart html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/checkout-step-one.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 5: At Page cart html click on button checkout --> navigate to Page checkout-step-one html'

testObj = findTestObject('AI-Generated/Page_cart_html/button_checkout')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/cart.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 6: Login at Page checkout-step-one html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/checkout-step-one.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 7: Add visual checkpoint at Page checkout-step-one html'

WebUI.takeFullPageScreenshotAsCheckpoint('TC4-Verify Successful Login and Proceed to Checkout from Cart Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
