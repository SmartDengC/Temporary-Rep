#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>

int wait_flag;
void stop(int a);

main(){
    int pid1, pid2;   // 定义两个进程变量
    signal(3,stop);  
    while((pid1=fork())==-1); // 若创建子进程失败，则空循环
    if(pid1>0){
	    while((pid2==fork()) == -1);
	    if(pid2>0){
            wait_flag = 1;
            sleep(5);
            kill(pid1, 16);
            kill(pid2, 17);
            wait(0);
            wait(0);
            printf("\n parent process is killed !!\n");
            exit(0);
	    }
        else{
            wait_flag = 1;
            signal(17, stop);
            printf("\n Chlild process 2 is killed by parent!!\n");
            exit(0);
        }

    }
    else{
        wait_flag = 1;
        signal(16, stop);
        printf("\n Child process 1 is killed by parent !!\n");
        exit(0);
    }
}
    
void stop(int a){
    wait_flag = 0;
}

