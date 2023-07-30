import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import internal.GlobalVariable as GslobalVariable
import org.openqa.selenium.Keys as Keys
import java.awt.AWTException as AWTException
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

String prjRoute = RunConfiguration.getProjectDir()
WebUI.openBrowser(GlobalVariable.URL_DEMOQA)

WebUI.maximizeWindow()
//Inicio Menú y subMenu 
WebUI.scrollToElement(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'), 1)

WebUI.click(findTestObject('Object Repository/PRACTICA1/Home/div_Elements'))

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Elements']))

WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Elements']))

//WebUI.executeJavaScript('document.body.style.zoom=\'60%\'', null)
Robot robot = new Robot()
//CustomKeywords.'AccionesNavegador.zoomOUt'(12)
for (int i = 0; i < 6; i++) {
    robot.keyPress(KeyEvent.VK_CONTROL)

    robot.keyPress(KeyEvent.VK_SUBTRACT)

    robot.keyRelease(KeyEvent.VK_SUBTRACT)

    robot.keyRelease(KeyEvent.VK_CONTROL)
}

//Iniciamos Sesión
WebUI.click(findTestObject('Object Repository/PRACTICA8/MENU1/menu', [('menu') : 'Book Store Application']))

WebUI.click(findTestObject('Object Repository/PRACTICA8/SUB_MENU/subMenu', [('subMenu') : 'Login']))

WebUI.setText(findTestObject('Object Repository/PRACTICA8/LOGIN/input_userName'), userName)

WebUI.setEncryptedText(findTestObject('Object Repository/PRACTICA8/LOGIN/input_password'), password)

WebUI.click(findTestObject('Object Repository/PRACTICA8/LOGIN/button_login'))

WebUI.takeScreenshot(prjRoute + '\\Imagenes\\tc8.jpg', FailureHandling.STOP_ON_FAILURE)
