import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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
import org.openqa.selenium.Keys as Keys
import java.util.regex.Matcher as Matcher
import com.GlobalVariableUpdater as GlobalVariableUpdater
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper as JsonSlurper
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Obter a data e hora atual
LocalDateTime agora = LocalDateTime.now()

// Formatar a data e hora no formato desejado (sem deslocamento de fuso horário)
DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
String dataFormatada = agora.format(formato)

println(dataFormatada)
GlobalVariable.SimpleDateFormat = dataFormatada
GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'SimpleDateFormat', dataFormatada)

ResponseObject resposta = WS.sendRequest(findTestObject('Nested_Resources/Create_Todos', [('SimpleDateFormat') : GlobalVariable.SimpleDateFormat]))

// Extrair e armazenar a resposta
String corpoResposta = resposta.getResponseBodyContent()

// Parse do JSON da resposta
def jsonSlurper = new JsonSlurper()

def responseObj = jsonSlurper.parseText(corpoResposta)
print(responseObj)
// Extrair os valores dos campos

def Id_Todos = responseObj.id.toString()
def title_Todos = responseObj.title

//Atualizar GlobalVariables
GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'Id_Todos', Id_Todos)
GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'title_Todos', title_Todos)