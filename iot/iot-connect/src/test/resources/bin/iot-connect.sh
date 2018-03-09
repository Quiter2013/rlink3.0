#!/bin/sh
## http://www.roncoo.com
## java env
export JAVA_HOME=/opt/jvm/jdk1.7.0_79
export JRE_HOME=$JAVA_HOME/jre

## service name
APP_NAME=iot-connect

SERVICE_DIR=/opt/robustlink/iot/$APP_NAME/bin
SERVICE_NAME=$APP_NAME
JAR_NAME=$SERVICE_NAME\.jar
PID=$SERVICE_NAME\.pid

do_start(){
    nohup $JRE_HOME/bin/java -Xms512m -Xmx1024m -jar $JAR_NAME >/dev/null 2>&1 &
    echo $! > $SERVICE_DIR/$PID
    echo "=== start $SERVICE_NAME"
}

 do_stop(){
    if [ -f $SERVICE_DIR/$PID ];then
	    P_ID=`cat $SERVICE_DIR/$PID`
	    ps -p $P_ID >/dev/null 2>&1
	    if [ "$?" = "0" ]; then
		  kill $P_ID
	    fi
	    rm -rf $SERVICE_DIR/$PID
	    echo "=== stop $SERVICE_NAME"
	fi

   sleep 5

    #再查询一遍，如果没有结束则强杀进程
	NPID=`ps -aux | grep java |grep "$SERVICE_NAME" | awk '{print $2}'`
	if [ ! -n "$NPID"  ]; then
		echo "=== $SERVICE_NAME process not exists or stop success"
	else
		echo "=== $SERVICE_NAME process pid is:$NPID"
		echo "=== begin kill $SERVICE_NAME process, pid is:$NPID"
		kill -9 $NPID
	fi
}

cd $SERVICE_DIR

case "$1" in
    start)
		do_start
		;;
    stop)
	    do_stop
	    ;;
    restart)
	    do_stop
        sleep 2
        do_start
        echo "=== restart $SERVICE_NAME"
	    ;;
     *)
		echo "usage: $0 {start|stop|restart}"
		exit 1
        ;;
    esac
exit 0