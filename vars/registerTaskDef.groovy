#!/usr/bin/env groovy

/**
  * Generate aws ecs register-task-definition command.
  *
  * @param taskDefFile path to task definition file.
  * @param region aws region.
  *
  * @return generated command as String.
  */
def call(String taskDefFile, String region) {
    return "aws ecs register-task-definition \
                --cli-input-json file://${taskDefFile} \
                --region ${region}"
}