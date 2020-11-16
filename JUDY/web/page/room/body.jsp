<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/20
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="body">
    <div class="img_hotel">
        <a href=""><img src="page/images/hero.jpg" height="530px"width="100%"></a>
    </div>
    <form action="userServlet">
        <input type="hidden" name="action" value="openRoom"/>
        <input type="hidden" name="grade_id" value="1">
        <div class="body_detail_roomsingle">
            <div class="body_room">
                <div class="room_check">
                    <div class="room_check_detail">
                        <div class="check_detail_left">
                            <div class="detail_left_picture">
                                <a href=""><img src="page/images/singleroom.jpg" width="253px" height="170px"></a>
                            </div>
                        </div>
                        <div class="check_detail_right">
                            <div class="detail_right_head">
                                <span>房间介绍</span>
                                <div class="detail_right_head_big"><span>房间数量：1&nbsp;|&nbsp;卫生间：1&nbsp;|&nbsp;面积：60平方米</span></div>
                                <div class="detail_right_head_roomdetail"><span>房间采光良好，有独卫，总计60平方米，我们有最先进的防火系统，楼道两侧有安全通道，保障通行。</span></div>
                            </div>
                            <div class="detail_right_body"><span>房间详情如上</span></div>
                            <div class="detail_right_foot"><hr/>
                                <div class="detail_right_foot_money">
                                    <span>金额</span><h2>$43RMB<input type="submit" class="right_foot_money_count"value="结算"name="submit"></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="room_check_foot_background"></div>
                </div>
            </div>
        </div>
    </form>
    <form action="userServlet">
        <input type="hidden" name="action" value="openRoom"/>
        <input type="hidden" name="grade_id" value="2">
        <div class="body_detail_roomstandrd">
            <div class="body_room">
                <div class="room_check">
                    <div class="room_check_detail">
                        <div class="check_detail_left">
                            <div class="detail_left_picture">
                                <a href=""><img src="page/images/standrdroom.jpg" width="253px" height="170px"></a>
                            </div>
                        </div>
                        <div class="check_detail_right">
                            <div class="detail_right_head">
                                <span>房间介绍</span>
                                <div class="detail_right_head_big"><span>房间数量：1&nbsp;|&nbsp;卫生间：1&nbsp;|&nbsp;面积：70平方米</span></div>
                                <div class="detail_right_head_roomdetail"><span>房间采光良好，有独卫，总计70平方米，我们有最先进的防火系统，楼道两侧有安全通道，保障通行。</span></div>
                            </div>
                            <div class="detail_right_body"><span>房间详情如上</span></div>
                            <div class="detail_right_foot"><hr/>
                                <div class="detail_right_foot_money">
                                    <span>金额</span><h2>$60RMB<input type="submit" class="right_foot_money_count"value="结算"name="submit"></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="room_check_foot_background"></div>
                </div>
            </div>
        </div>
    </form>
    <form action="userServlet">
        <input type="hidden" name="action" value="openRoom"/>
        <input type="hidden" name="grade_id" value="2">
        <div class="body_detail_roomdouble">
            <div class="body_room">
                <div class="room_check">
                    <div class="room_check_detail">
                        <div class="check_detail_left">
                            <div class="detail_left_picture">
                                <a href=""><img src="page/images/doubleroom.jpg" width="253px" height="170px"></a>
                            </div>
                        </div>
                        <div class="check_detail_right">
                            <div class="detail_right_head">
                                <span>房间介绍</span>
                                <div class="detail_right_head_big"><span>房间数量：1&nbsp;|&nbsp;卫生间：1&nbsp;|&nbsp;面积：80平方米</span></div>
                                <div class="detail_right_head_roomdetail"><span>房间采光良好，有独卫，总计80平方米，我们有最先进的防火系统，楼道两侧有安全通道，保障通行。</span></div>
                            </div>
                            <div class="detail_right_body"><span>房间详情如上</span></div>
                            <div class="detail_right_foot"><hr/>
                                <div class="detail_right_foot_money">
                                    <span>金额</span><h2>$93RMB<input type="submit" class="right_foot_money_count"value="结算"name="submit"></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="room_check_foot_background"></div>
                </div>
            </div>
        </div>
    </form>
    <form action="userServlet">
        <input type="hidden" name="action" value="openRoom"/>
        <input type="hidden" name="grade_id" value="4">
        <div class="body_detail_roomdfamily">
            <div class="body_room">
                <div class="room_check">
                    <div class="room_check_detail">
                        <div class="check_detail_left">
                            <div class="detail_left_picture">
                                <a href=""><img src="page/images/familyroom.jpg" width="253px" height="170px"></a>
                            </div>
                        </div>
                        <div class="check_detail_right">
                            <div class="detail_right_head">
                                <span>房间介绍</span>
                                <div class="detail_right_head_big"><span>房间数量：1&nbsp;|&nbsp;卫生间：1&nbsp;|&nbsp;面积：90平方米</span></div>
                                <div class="detail_right_head_roomdetail"><span>房间采光良好，有独卫，总计90平方米，我们有最先进的防火系统，楼道两侧有安全通道，保障通行。</span></div>
                            </div>
                            <div class="detail_right_body"><span>房间详情如上</span></div>
                            <div class="detail_right_foot"><hr/>
                                <div class="detail_right_foot_money">
                                    <span>金额</span><h2>$120RMB<input type="submit" class="right_foot_money_count"value="结算"name="submit"></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="room_check_foot_background"></div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
