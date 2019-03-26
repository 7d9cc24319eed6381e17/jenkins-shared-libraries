def call() {
    def taskDefPath = "${env.WORKSPACE}/task_definition/${env.APP_NAME}-${env.ENVIRONMENT}-${env.APPLICATION_TAG}.json"

    sh """
        sed 's/APPLICATION_TAG/'\"${env.APPLICATION_TAG}\"'/g; \ 
            s/AWS_ACCOUNT_ID/'\"${env.AWS_ACCOUNT_ID}\"'/g;' \
            task_definition/${env.ENVIRONMENT}.json.tpl > ${taskDefPath}
    """

    return taskDefPath
}