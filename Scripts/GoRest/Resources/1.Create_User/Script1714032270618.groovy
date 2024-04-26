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

// Obter o valor atual da variável GlobalVariable.email
def emailAtual = GlobalVariable.email

// Extrair o número do email atual
def matcher = emailAtual =~ '\\d+'

def numeroAtual = matcher.find() ? matcher.group().toInteger() : 1

// Incrementar o número
def novoNumero = numeroAtual + 1

// Substituir o número no email
def novoEmail = emailAtual.replaceAll('\\d+', novoNumero.toString())

// Atualizar a variável GlobalVariable.email
GlobalVariable.email = novoEmail
status = GlobalVariable.status= "active"
GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'email', novoEmail)
GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'status', status)
// Imprimir o novo email para verificar
println("Novo Email: $GlobalVariable.email")

// Enviar a solicitação HTTP e capturar a resposta
ResponseObject resposta = WS.sendRequest(findTestObject('Resources/Create_User', [('email') : GlobalVariable.email, ('gender') : GlobalVariable.gender
            , ('status') : GlobalVariable.status]))

// Obter o código de status da resposta
int codigoStatus = resposta.getStatusCode()

println(codigoStatus)

// Assert para verificar se o código de status é 201 (Criado)
assert codigoStatus == 201

println("Solicitação bem-sucedida! Código de status: $codigoStatus")

// Extrair e armazenar o ID do User da resposta
String corpoResposta = resposta.getResponseBodyContent()

def jsonResposta = new groovy.json.JsonSlurper().parseText(corpoResposta)

String idUser = jsonResposta.id

println("ID do User: $idUser")

//Atualiza a GlobalVariable.ID_USer
GlobalVariable.Id_User = idUser

GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'Id_User', idUser)