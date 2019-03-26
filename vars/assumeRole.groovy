#!/usr/bin/env groovy

/**
  * Generate aws-cli command with assume role.
  *
  * @param assumeRole aws assume role arn.
  * @param command aws cli command to run.
  *
  * @return generated command as String.
  */
def call(String assumeRole, String command) {
    return """ \\
        set +x;
        eval \$(aws sts assume-role \\
            --role-arn ${assumeRole} \\
            --role-session-name "aws-jenkins-session" \\
            --duration-seconds 900 \\
            --output text | \\
            grep CREDENTIALS | \\
            awk '{print "AWS_ACCESS_KEY_ID="\$2" AWS_SECRET_ACCESS_KEY="\$4" AWS_SESSION_TOKEN="\$5" ${command}"}') 
   """
}