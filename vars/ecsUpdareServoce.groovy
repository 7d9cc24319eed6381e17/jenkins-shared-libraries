#!/usr/bin/env groovy

/**
  * Generate aws ecs register-task-definition command.
  *
  * @param taskDefFile path to task definition file.
  * @param region aws region.
  *
  * @return generated command as String.
  */
def call(String appName, String region, String cluster, String arn) {
    return """ 
        aws ecs update-service \
            --cluster ${cluster} \
            --service ${appName} \
            --task-definition ${arn} \
            --region ${region}
    """
}