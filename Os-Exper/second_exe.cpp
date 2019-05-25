#include <stdio.h>
#include <string.h>
#include <iostream>
using namespace std;
const int block_time = 10; // define max time is 10 second
const int MAXPCB = 100; // define max process number
// def struct
typedef struct node{
	char name[20];
	int status;
	int time;
	int privilege;
	int finished;
	int wait_time;
	struct node *pcbs;
	//struct node pcbs[MAXPCB];
	int quantity;
};
struct node pcbs;
// init func
void initial(){
	int i;
	for(i=0;i<MAXPCB;i++){
		strcpy(pcbs[i].name, "");
		pcbs[i].status=0;
		pcbs[i].time=0;
		pcbs[i].privilege=0;
		pcbs[i].finished=0;
		pcbs[i].wait_time=0;
	}
	quantity=0;
}
// read data func
int readData(){
	FILE *fp;
	char fname[20];
	int i;
	cout<<"input your process file name:";
	cin>>fname;
	if((fp=fopen(fname,"r"))==NULL){
		cout<<"error,file can not opened,please checkin filename"<<endl;
	}
	else{
		while(!feof(fp)){
			fscanf(fp,"%s%d%d%d",pcbs[quantity].name,&pcbs[quantity].status,
				&pcbs[quantity].time,&pcbs[quantity].privilege
					); 
			quantity++;
		}
		cout<<"output data"<<endl;
		cout<<"process name,status,need time,first number"<<endl;
		for(i=0;i<quantity;i++){
			cout<<"    "<<pcbs[i].name<<"    "<<pcbs[i].status<<"    "<<pcbs[i].time<<"    "<<pcbs[i].privilege<<endl;
		}
		return (1);

	}
	return (0);
}
void init(){
	int i;
	for(i=0;i<MAXPCB;i++){
		pcbs[i].finished=0;
		pcbs[i].wait_time=0;
	}
}
//fifo
void FIFO(){
	int i,j;
	int total;
	cout<<endl<<"*******************"<<endl;
	cout<<"FIFO 执行流:"<<endl;
	cout<<"进程名 等待时间"<<endl;
	for(i=0;i<quantity;i++){
		cout<<" "<<pcbs[i].name<<""<<pcbs[i].wait_time<<endl;
		for(j=i+1;i<quantity;i++){
			pcbs[j].wait_time+=pcbs[i].time; 

		}
	}
	total=0; 
	for(i=0;i<quantity;i++)
	{ total+=pcbs[i].wait_time; } 
		cout<<"总等待时间:"<<total<<" 平均等待时间:"<<total/quantity<<endl;

		
}
//时间片轮转调度算法
void timer(){
	int i,j,number,flag = 1;
	int passed_time = 0;
	int max_time = 0;
	int round=0;
	int queue[1000];
	int total=0;
	while(flag==0){
		flag=0;
		number=0;
		for(i=0;i<quantity;i++){
			if(pcbs[i].finished==0){
				number++;
				j=i;
			}
			if(number==1){
				queue[total]=j;
				total++;
				pcbs[j].finished=1;
			}
			if(number>1){
				for(i=0;i<quantity;i++){
					if(pcbs[i].finished==0){
						flag=1;
						queue[total]=i;
						total++;
						if(pcbs[i].time<=block_time*(round+1)){
							pcbs[i].finished=1;
						}
					}
				}
			}
			round++;
		}
		if(queue[total-1]==queue[total-2]){
			total--;
			cout<<endl<<"*************"<<endl;
			cout<<"时间片轮转调度执行流:"<<endl;
			for(i=0;i<total;i++){
				cout<<pcbs[queue[i]].name<<"";
					cout<<endl;
			}	
		}
	}

}
//显示
//
void version(){
	cout<<"     /*********进程调度***********/    ";
	cout<<endl<<endl;
}
//主函数
//
int main(){
	int flag;
	version();
	initial();
	flag=readData();
	if(flag==1){
		FIFO();
		init();
		privilege();
		init();
		timer();
	}
	return 0;
}
