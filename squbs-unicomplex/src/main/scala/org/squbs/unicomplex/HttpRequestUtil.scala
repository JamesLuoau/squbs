/*
 *  Copyright 2015 PayPal
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.squbs.unicomplex

import spray.http.HttpRequest

object HttpRequestUtil {

  implicit class HttpRequestAdapter(val request: HttpRequest) extends AnyVal {

    def getWebContext: Option[String] = {
      request.headers.find(_.isInstanceOf[WebContextHeader]) match {
        case None => None
        case Some(header) => Option(header.value)
      }
    }

  }

}
