# CSCi 4145
### for project in CSCI4145 cloud computing

# introduction
this is a blog project
build by springboot and mybatis
and use docker to deploy
with aws server


# Author
- [JingxuanWei](jn728702@dal.ca)
- B00844431

## how to send to the docker
1. `cd csci4145`
2. `docker build -t myproject . `
3. `docker login `
4. `docker tag myproject weijingxuan925/vlog:latest`
5. `docker push weijingxuan925/vlog:latest`

## pull from docker
1. `docker pull weijingxuan925/vlog:latest`
2. `docker run -p 80:80 -d weijingxuan925/vlog:latest`
3. `docker run -p 80:80 --name myproject --network host -e SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/flame -e  SPRING_DATASOURCE_USERNAME=root -e  SPRING_DATASOURCE_PASSWORD=Wjx010925 weijingxuan925/vlog`
4. 注意，使用这种网络模式有一些限制和安全隐患，请确保你理解这些风险并根据你的实际情况来决定是否使用这种方式。如果你不确定，那么请使用默认的桥接网络模式。

## how to run
1. install docker
2. install docker-compose
3. run `docker-compose up`
4. open browser and go to `localhost:80`

# CITATIONS

## Backends citation: 
1. [EasyCode](https://github.com/makejavas/EasyCode)
2. [SpringBoot](https://spring.io/projects/spring-boot)
3. [SpringSecurity](https://spring.io/projects/spring-security)
4. [SpringDataJPA](https://spring.io/projects/spring-data-jpa)
5. [mybatis](https://mybatis.org/mybatis-3/)
6. [maven](https://maven.apache.org/)
7. [mysql](https://www.mysql.com/)


## Frontend citation: 
##### all project and its dependencies are open source and free to use with MIT license
1. [uxsolutions/bootstrap-datepicker v1.7.0](https://github.com/uxsolutions/bootstrap-datepicker)
2. [Font Awesome 4.7.0 by Dave Gandy](http://fontawesome.io)
3. [Bootstrap by The Bootstrap Authors](https://github.com/twbs/bootstrap/blob/master/LICENSE)
4. [Lightbox2 by Lokesh Dhakar](https://github.com/lokesh/lightbox2/blob/master/LICENSE)
5. [Magnific Popup by Dmitry Semenov](http://dimsemenov.com/plugins/magnific-popup/)
6. [uxsolutions/bootstrap-datepicker v1.7.0](https://github.com/uxsolutions/bootstrap-datepicker)
7. [Font Awesome 4.7.0 by Dave Gandy](http://fontawesome.io)
8. [Bootstrap by The Bootstrap Authors](https://github.com/twbs/bootstrap/blob/master/LICENSE)
9. [Lightbox2 by Lokesh Dhakar](https://github.com/lokesh/lightbox2/blob/master/LICENSE)
10. [Magnific Popup by Dmitry Semenov](http://dimsemenov.com/plugins/magnific-popup/) 
11. [Masonry by David DeSandro](https://masonry.desandro.com) 
12. [Parallax.js by Matthew Wagerfield](https://github.com/pixelcog/parallax.js/blob/master/LICENSE)
13. [Animate.css by Dan Eden](http://daneden.me/animate)
14. [Bonzo by Dustin Diaz](https://github.com/ded/bonzo)
15. [Modernizr by Faruk Ates, Paul Irish, Alex Sexton, Ryan Seddon, Patrick Kettner, and others](http://modernizr.com/download/#-csstransitions-shiv-cssclasses-prefixed-testprop-testallprops-domprefixes-load)
16. [Skrollr by Alexander Prinzhorn](https://github.com/Prinzhorn/skrollr)
17. [Bootstrap Social by Lipis](https://github.com/lipis/bootstrap-social)
18. [AdminLTE by Almsaeed Studio](https://adminlte.io/)
19. [Krub font by Cadson Demak](https://fonts.googleapis.com/css?family=Krub:400,500,600)
20. [Normalize.css by Nicolas Gallagher and Jonathan Neal](https://github.com/necolas/normalize.css)
21. [Animate.css by Dan Eden](http://daneden.me/animate)
22. [Bootstrap by The Bootstrap Authors](https://github.com/twbs/bootstrap)
23. [Bootstrap Fileinput by Kartik Visweswaran](http://plugins.krajee.com/file-input)
24. [nghuuphuoc on Twitter](http://twitter.com/nghuuphuoc)
25. [Font Awesome 4.7.0 by Dave Gandy](http://fontawesome.io)
26. [Froala Editor v2.9.1 by Froala](https://www.froala.com/wysiwyg-editor) 
27. [jQuery v3.2.1 by JS Foundation and other contributors](https://jquery.org/license)
28. [Layer Mobile v2.0.0 Web弹层组件 by Kevin Liang](http://layer.layui.com/mobile)
29. [Lazy Load by Mika Tuupola](http://www.appelsiini.net/projects/lazyload)
30. [jQuery Pjax by Chris Wanstrath](https://github.com/defunkt/jquery-pjax)
31. [Pretty Checkbox by Lokesh](https://github.com/lokesh-coder/pretty-checkbox)
32. [TinyMCE by Ephox](https://www.tiny.cloud/)
33. [Toastify-js by Kamran Ahmed](https://www.npmjs.com/package/toastify-js)
