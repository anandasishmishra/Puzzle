package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;
import twitter4j.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Multunus Twitter Puzzle</title>\n");
      out.write("        \n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"multunus.css\">\n");
      out.write("        \n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("        <script src=\"mult.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-image:url('http://puzzle.multunus.com/assets/watch_minimized-8f2f2b01514d433754b4f2c47d4cee58.png'); background-size: 100%\">\n");
      out.write("        \n");
      out.write("        <div id=\"explanation\" onclick=\"hideExplanation()\" >\n");
      out.write("            <img id=\"arrowCentre\" border=\"0\" src=\"whitearrow.png\" width=\"100\" height=\"100\"/>\n");
      out.write("            <img id=\"arrowRetweeters\" border=\"0\" src=\"whitearrow2.png\" width=\"100\" height=\"100\"/>\n");
      out.write("            <img id=\"arrowRanks\" border=\"0\" src=\"whitearrow2.png\" width=\"100\" height=\"100\"/>\n");
      out.write("            \n");
      out.write("            <div id=\"explainCentre\">\n");
      out.write("                <span id=\"explainCentreText\" >This is the owner of the tweet.</span>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"explainRetweeters\">\n");
      out.write("                <span id=\"explainRetweetersText\" style=\"color: white;\">These are the users who retweeted the tweet.</span>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"explainRanks\">\n");
      out.write("                <span id=\"explainRanksText\" style=\"color: white;\">\n");
      out.write("                    The numbers indicate the rank of the retweeters according to their number of followers.<br/>\n");
      out.write("                    The retweeter with the highest number of followers has rank 1 and likewise.\n");
      out.write("                </span>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("In5YecDqK6b8qci45oRnbQ")
                    .setOAuthConsumerSecret("quJblw8Nc3R55gDssaOqBTOdiqmoyJbku0mB9Sc0")
                    .setOAuthAccessToken("2162301348-PcjKzbmcM2q0ImoA6eTJw2CCvL9SUoqTiMKQuoi")
                    .setOAuthAccessTokenSecret("9WBvozULFTwZircPDDMWNbaR3UoDRqytrkCxq5kurWqZ5");
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            IDs ids=twitter.getRetweeterIds(445394248100487168l, 200);

            TreeMap<Integer, Long> retweeterIdAndFollowerCount= new TreeMap<Integer, Long>();
            List<Integer> followersCount=new ArrayList<Integer>();

            for(long id:ids.getIDs()){
                User user=twitter.showUser(id);
                int followerCount=user.getFollowersCount();
                retweeterIdAndFollowerCount.put(followerCount,id);
                followersCount.add(followerCount);
            }

            Collections.sort(followersCount);
            Collections.reverse(followersCount);

            for(int i=0;i<10;i++){
                Long retweetersId=retweeterIdAndFollowerCount.get(followersCount.get(i));
                User user=twitter.showUser(retweetersId);
                String profilePicURL = user.getProfileImageURL();
        
      out.write("\n");
      out.write("        <div class=\"around\" style=\"background-image: url(");
      out.print(profilePicURL);
      out.write(");background-size:100%;\">\n");
      out.write("            <div id=\"abc\" class=\"blackCoat\">\n");
      out.write("                <span style=\"color: white;font-size: 70px;margin-left: 30%\">");
      out.print(i+1);
      out.write("</span>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <a href=\"javascript:void(0);\" onclick=\"showExplanation()\">Show Explanation</a>\n");
      out.write("        <img id=\"centre\" border=\"0\" src=\"http://pbs.twimg.com/profile_images/426158315781881856/sBsvBbjY.png\" >\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
