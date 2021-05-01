*** Settings ***
Documentation    User Accounts RestApi Test With Robot Framework
Library   RequestsLibrary
Library    Collections

*** Variables ***
${Base_URL}		http://localhost:8080/v1/user-accounts
${SUCCESS}		200
${NOT_FOUND}	404
${CREATED}		201
${BAD_REQUEST}		400
${INTERNAL_ERROR}		501


*** Test Cases ***
TC_000_Create_Account
    createSession   Create_Account    ${Base_URL}
    &{data}=    create dictionary	id=1    name=Guneykan   phone=9999999999    email=test@test.com     address=Merdivenkoy     country=TR      department=IT
    &{header}=    create dictionary	Content-Type=application/json

    ${response}=    POST On Session	Create_Account  /   json=${data}    headers=${header}
    log to console  ${response.status_code}

#    Validations
	${status_code}=		convert to string	${response.status_code}
	should be equal		${status_code}		${CREATED}

TC_001_Get_All_Accounts
    createSession   Get_All_Accounts    ${Base_URL}
    ${response}=    GET On Session	Get_All_Accounts	/all
    log to console  ${response.status_code}

#    Validations
	${status_code}=		convert to string	${response.status_code}
	should be equal		${status_code}		${SUCCESS}

	${body}=		convert to string	${response.content}
	should contain		${body}		name

TC_002_Find_Account_ById
    createSession   Find_Account_ById    ${Base_URL}
    ${response}=    GET On Session	Find_Account_ById	/1
    log to console  ${response.status_code}

#    Validations
	${status_code}=		convert to string	${response.status_code}
	should be equal		${status_code}		${SUCCESS}

	${body}=		convert to string	${response.content}
	should contain		${body}		name

TC_003_Update_Account
    createSession   Create_Account    ${Base_URL}
    &{data}=    create dictionary	id=1    name=Guneykan3   phone=999993399999    email=test@test.com     address=Merdivenkoy     country=TR      department=IT
    &{header}=    create dictionary	Content-Type=application/json

    ${response}=    PUT On Session	Create_Account  /   json=${data}    headers=${header}
    log to console  ${response.status_code}

#    Validations
	${status_code}=		convert to string	${response.status_code}
	should be equal		${status_code}		${CREATED}

#TC_004_Bad_Request_Email_Not_Valid_On_Create_Account
#    createSession   Create_Account    ${Base_URL}
#    &{data}=    create dictionary	id=1    name=Guneykan   phone=99999999998888    email=testtest.com     address=Merdivenkoy     country=TR      department=IT
#    &{header}=    create dictionary	Content-Type=application/json
#
#    ${response}=    POST On Session	Create_Account  /   json=${data}    headers=${header}
#    log to console  ${response.status_code}
#
##    Validations
#	${status_code}=		convert to string	${response.status_code}
#	should be equal		${status_code}		${BAD_REQUEST}
#
#    ${body}=		convert to string	${response.content}
#    should contain		${body}		Email is not valid


TC_005_Delete_Account
    createSession   Delete_Account    ${Base_URL}
    ${response}=    DELETE On Session	Delete_Account	/1
    log to console  ${response.status_code}

#    Validations
	${status_code}=		convert to string	${response.status_code}
	should be equal		${status_code}		${SUCCESS}

	${body}=		convert to string	${response.content}
	should contain		${body}		message
