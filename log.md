### 03/24

* 登陆界面还存在一些问题，不能对登陆不成功的情况做出反应。如果想
添加校验功能，可以去[这个网址][2]。


* 每次自动生成实体类，都会重写hibernate的配置文件，然后还会写错。哭。我先存在这里。

    `    
    <property name="connection.url">jdbc:mysql://134.209.5.99:3306/xyl?useUnicode=true&amp;characterEncoding=UTF8</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
    <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">XYLxyl2019!?</property>
    `

* mysql数据库有个小问题，每次启动，时区都是null。然后跑tomcat就会报错。可以通过下面的代码设置时区，但是每次关机完又不行了，估计需要**在配置文件里面**改一下。欸，可是我这么设置完以后，再开机就没事了
  
  `
  set global time_zone = '+8:00'; ##修改mysql全局时区为北京时间，即我们所在的东8区
  set time_zone = '+8:00'; ##修改当前会话时区
  flush privileges; #立即生效
  `

* jsp中间出现了中文乱码的问题，尝试在标题中加入了 `<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>`没用，然后看了一下教程，[戳这里][1]。遇到过这么多乱码问题，虽然到现在也没大明白，但是大概就是因为转译编译执行的过程中，不同的字符编码之间的差异把？
  * vscode里面试过改变文件编码格式，成功
  * idea ctrl+shift+a 搜索功能，**content type**虽然不知道干啥的，但是是off状态，我打开了，欸，就好了。

* <19/03/26>遇到了一个fatal problem
  * 问题描述：在数据库建立活动表的时候，沾沾自喜的尝试~~高端~~操作，主键设置成了auto_increment，sql 语句是` id int primary key auto_increment`，结果发现出了问题，我创建**活动实体**是需要id的值的，但是我必须**存到数据库以后**才能获取id，而实体创建在进行数据库操作之前，就很尴尬了，如果不获取会导致实体的id和数据库中的id不一致，后期查找删除会出问题。
  * 问题解决：找了很多办法。针对hibernate可以的添加操作，是可以通过一下代码获取的：         
  `
  Object obj = new Object();      
  session.save(obj);
  int id = obj.getId(); 
  `         
  或者是        
  `
  Object obj = new Object();
  int id = session.save(obj);
  `
  * 然而，图样图森破。无论我怎么尝试，这里获取的**id值都是0**。然后查了很多资料。最后找到问题在配置文件：   
  `
  <id name="aid" column="aid">
            <generator class="identity"/>
        </id>
        `
    
    * name属性不能少，不然也有可能出错。笔者这里是idea中自动创建的配置文件，所以该有都有。
    * ！（划重点）虽然我在数据库设置了自增属性，但是自动产生的配置文件没有generator这一行。具体作用，我再查一下。加上这个就好了。




[1]: https://baijiahao.baidu.com/s?id=1612248889715571983&wfr=spider&for=pc

[2]: https://www.tutorialspoint.com/springmvc/springmvc_hibernate_validator.htm