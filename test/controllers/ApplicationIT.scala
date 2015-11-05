package controllers

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

/**
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationIT extends Specification {

  "Application" should {

    "send 404 on a bad request" in {
      running(FakeApplication()) {
        val nosuchresource = route(FakeRequest(GET, "/boum")).get
        status(nosuchresource) must equalTo(NOT_FOUND)
      }
    }

    "render the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
      }
    }

  }
}