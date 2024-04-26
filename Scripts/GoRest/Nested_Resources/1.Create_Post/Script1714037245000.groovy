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

// Verifica o valor da GlobalVariable.status
def status = GlobalVariable.status

if (status == 'active') {
    println('O User está ativo, vamos criar um post')

    // Enviar a solicitação e verificar a resposta
    ResponseObject resposta = WS.sendRequestAndVerify(findTestObject('Nested_Resources/Create_Post'))

    // Extrair e armazenar a resposta
    String corpoResposta = resposta.getResponseBodyContent()

    // Parse do JSON da resposta
    def jsonSlurper = new JsonSlurper()

    def responseObj = jsonSlurper.parseText(corpoResposta)

    // Extrair os valores dos campos
    def id_Post = responseObj.id.toString( // Converte para String
        )

    def userId = responseObj.user_id.toString( // Converte para String
        )

    def title_Post = responseObj.title

    def body_Post = responseObj.body

    //Atualizar GlobalVariables
    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'Id_Post', id_Post)

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'Id_User', userId)

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'title_Post', title_Post)

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'body_Post', body_Post)

    // Imprimir os valores para verificação
    println("ID: $id_Post")

    println("User ID: $userId")

    println("Title: $title_Post")

    println("Body: $body_Post") // Enviar a solicitação e verificar a resposta
    // Extrair e armazenar a resposta
    // Parse do JSON da resposta
    // Extrair os valores dos campos
    // Converte para String
    // Converte para String
    //Atualizar GlobalVariables
    // Imprimir os valores para verificação
} else {
    println('O User nao está ativo, vamos criar um novo User para efetuar um Post')

    WebUI.callTestCase(findTestCase('GoRest/Resources/1.Create_User'), [:], FailureHandling.STOP_ON_FAILURE)

    ResponseObject resposta = WS.sendRequestAndVerify(findTestObject('Nested_Resources/Create_Post'))

    String corpoResposta = resposta.getResponseBodyContent()

    def jsonSlurper = new JsonSlurper()

    def responseObj = jsonSlurper.parseText(corpoResposta)

    def id_Post = responseObj.id.toString()

    def userId = responseObj.user_id.toString()

    def title_Post = responseObj.title

    def body_Post = responseObj.body

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'Id_Post', id_Post)

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'Id_User', userId)

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'title_Post', title_Post)

    GlobalVariableUpdater.updatePermanently(RunConfiguration.getExecutionProfile(), 'body_Post', body_Post)

    println("ID: $id_Post")

    println("User ID: $userId")

    println("Title: $title_Post")

    println("Body: $body_Post")
}