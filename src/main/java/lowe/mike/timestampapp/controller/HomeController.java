package lowe.mike.timestampapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Home controller.
 *
 * @author Mike Lowe
 */
@Controller
public class HomeController {

  @GetMapping("/")
  public String index(final HttpServletRequest request, final Model model) throws MalformedURLException {
    model.addAttribute("app_url", getAppUrl(request));
    return "index";
  }

  public String getAppUrl(final HttpServletRequest request) throws MalformedURLException {
    final URL requestURL = new URL(request.getRequestURL().toString());
    final String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
    return requestURL.getProtocol() + "://" + requestURL.getHost() + port;
  }

}
