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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

// Enviar a requisição e obter a resposta
ResponseObject resposta = WS.sendRequest(findTestObject('Nested_Resources/Get_Comments'))

// Obter o conteúdo da resposta como uma string JSON
String responseBody = resposta.getResponseBodyContent()

// Imprimir a resposta para debug
println(responseBody)

// Obter o código de status da resposta
int codigoStatus = resposta.getStatusCode()

println(codigoStatus)

// Assert para verificar se o código de status é 200 (Sucesso)
assert codigoStatus == 200
println("Solicitação bem-sucedida! Código de status: $codigoStatus")

// Criar um objeto JsonSlurper para analisar a string JSON
JsonSlurper slurper = new JsonSlurper()

// Parse da string JSON para um objeto JSON
def jsonResposta = slurper.parseText(responseBody)

// Acessar a propriedade 'body' do objeto JSON
def bodyDaResposta = jsonResposta.body

// Assert para verificar se o 'body' na resposta corresponde à GlobalVariable 'body_Post'
assert bodyDaResposta == GlobalVariable.body_Comments

println("Assert bem-sucedido para a GlobalVariable 'body_Comments'")
