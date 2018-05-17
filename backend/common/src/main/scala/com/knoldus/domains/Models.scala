package com.knoldus.domains

import java.util.Date

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class UserInfo(emailId: String, userType: Option[String] = None)

final case class UserDetails(emailId: String, password: String, userType: Option[String] = None)

final case class SessionDetails(date: Date,
                        trainee: String,
                        technologyName: String,
                        numberOfDays: Int,
                        content: String,
                        assistantTrainer: Option[String])


final case class ScheduleInfo(sessionId: String,
                              date: String,
                              trainee: String,
                              technologyName: String,
                              numberOfDays: Int,
                              content: String,
                              assistantTrainer: Option[String])

case class SessionInfo(sessionId: String, date: String)


case object UserInfo extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val userProtocol: RootJsonFormat[UserInfo] = jsonFormat2(UserInfo.apply)
}


case object UserDetails extends DefaultJsonProtocol with SprayJsonSupport {
    implicit val userLoginRequestProtocol = jsonFormat3(UserDetails.apply)
  }

