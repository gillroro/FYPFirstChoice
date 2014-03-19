<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>gBook</title>

<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/coda-slider.css" type="text/css" />

<script src="js/jquery-1.2.6.js" type="text/javascript"></script>
<script src="js/jquery.scrollTo-1.3.3.js" type="text/javascript"></script>
<script src="js/jquery.localscroll-1.2.5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.serialScroll-1.2.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/coda-slider.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	
    <div id="slider">
    <div id="templatemo_wrapper">
    	
        <div id="header">
            
            <div id="site_title"><img src = "http://www.freeclipartnow.com/d/39958-1/gold-letter-G.jpg" width = "200" height = "150"></div>
            
            <div id="menu">
                <ul class="navigation">
                    <li><a href="#home" class="selected">Home<span class="ui_icon home"></span></a></li>
                    <li><a href="#gallery">Friends<span class="ui_icon gallery"></span></a></li>
					<li><a href="#message">Messages<span class="ui_icon message"></span></a></li>
                   
                </ul>
            </div>
        </div>
        
        <div id="content">
        
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                    	<div class="col_400 float_l">
                           <h1>Home</h1>
								<h2><em>Welcome to your gBook!</h2></em>
								<h3><strong>Comments</strong></h3>
								
								<s:iterator value = "comments">
								</s:iterator>
								
								<img src = "http://www2.kvmr.org/pers_images/blank_profile.jpg" align ="right">
								
								
                        </div>
                        
                        
                    </div> <!-- end of home -->
                    
                    
                    
                    <div class="panel" id="services">
                    
                    	
                         
                    
                        
                    </div>
                
                    <div class="panel" id="gallery">
                        <h1>Friends</h1>
                        
                        <div id="gallery_container">
                         
                          
                            <div class="cleaner"></div>
                        </div>
                
                    </div>
                
                    <div class="panel" id="message">
                    	<h1>Message</h1>
                       
                                                
                        <div class="col_400 float_r">
                            <div id="contact_form">
                                <h1><em>Your message has been sent. Thanks! </em></h1>
                            </div>
						</div>
                        
                        <div class="col_380 float_r">
                        
                        </div>
                	</div>
                    
                </div>
            </div>
            
            <!-- end of scroll -->
        
        </div> <!-- end of content -->
        
        
        
        <div id="footer">
        
            <div id="social_box">
                <a href="http://www.facebook.com"><img src="images/facebook.png" alt="facebook" /></a>
                <a href="http://www.flickr.com"><img src="images/flickr.png" alt="flickr" /></a>
                <a href="http://www.myspace.com"><img src="images/myspace.png" alt="myspace" /></a>
                <a href="http://www.twitter.com"><img src="images/twitter.png" alt="twitter" /></a>
                <a href="http://www.youtube.com"><img src="images/youtube.png" alt="youtube" /></a>
            </div>

            
        </div>
    
    </div> <!-- end of wrapper -->
    </div> <!-- end of slider -->

</body>
</html>