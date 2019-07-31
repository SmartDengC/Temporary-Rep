import numpy as np
import pandas as pd
import matplotlib.pyplot as plt


def to_solve_q1(df_obj):
    """
    统计每年的日平均PM2.5指数，日平均气温，并分别用柱状图显示
    要求图有中文标题，坐标轴说明
    :param df_obj: data set
    :return: null
    """
    # preview data
    pro_see_data(df_obj)
    # deal with the NaN data
    df_obj = df_obj.dropna()
    # choice  column year pm2.5 TEMP
    df_1 = df_obj[['year', 'pm2.5', 'TEMP']]
    # group by and order
    pm = df_1.groupby(['year']).mean()
    pm.reset_index(inplace=True)
    width = 0.15
    plt.xlabel('Years')
    plt.ylabel('Values')
    plt.title('PM 2.5 and TEMP mean EveryYear')
    plt.bar(pm['year']-width, pm['pm2.5'], color='r', width=0.3, label='pm2.5')
    plt.bar(pm['year']+width, pm['TEMP'], color='g', width=0.3, label='TEMP')
    plt.legend(bbox_to_anchor=(0.8, 1))
    plt.show()


def to_solve_q2(df_obj):
    """
    采用2*2子图，以折线图展示5年内PM2.5，气温，气压，累计降雨量趋势图
    :param df_obj:  data set
    :return:  null
    """
    pro_see_data(df_obj)
    df = df_obj[['year', 'pm2.5', 'TEMP', 'PRES', 'Iws']]
    # 处理空值
    # df['pm2.5'].fillna(df['pm2.5'].mean())._update_inplace(df)
    df = df.dropna()
    print(df)
    gb = df.groupby('year').mean()
    gb.reset_index(inplace=True)
    fig = plt.figure()
    ax1 = fig.add_subplot(2, 2, 1)
    ax2 = fig.add_subplot(2, 2, 2)
    ax3 = fig.add_subplot(2, 2, 3)
    ax4 = fig.add_subplot(2, 2, 4)

    ax1.set(xlabel='year', ylabel='pm2.5', title='pm2.5/year')
    ax1.plot(gb['year'], gb['pm2.5'], 'r--')
    ax2.set(xlabel='year', ylabel='TEMP', title='TEMP/year')
    ax2.plot(gb['year'], gb['TEMP'], 'g--')
    ax3.set(xlabel='year', ylabel='PRES', title='PRES/year')
    ax3.plot(gb['year'], gb['PRES'], 'b--')
    ax4.set(xlabel='year', ylabel='Iws', title='Iws/year')
    ax4.plot(gb['year'], gb['Iws'], 'y--')
    ax1.legend()
    ax2.legend()
    ax3.legend()
    ax4.legend()
    plt.show()


def to_solve_q3(df_obj):
    """
    统计每年pm2.5指数平均值最高的5个月，获取每天的pm2.5指数，并绘制到统一图表上
    汇出折线图（不同的年份不同的颜色）
    :param df_obj:  data set
    :return:  none
    """
    # pro_see_data(df_obj)
    df_obj = df_obj.dropna()
    years = list(df_obj.groupby('year').size().index)
    color=['black','red','blue','yellow','green']
    for year in years:
        # 取出当年数据，只要month， day， pm2.5
        cur_year_datas = df_obj.loc[df_obj['year'] == year, ['month', 'day', 'pm2.5']]
        # 求出pm2.5 月平均
        cur_year_pm = cur_year_datas.groupby('month')['pm2.5'].mean()
        # sort after data
        cur_year_pm_1 = cur_year_pm.sort_values(ascending=False)
        # choice which month is top 5
        months = list(cur_year_pm_1.index[:5])
        # use day number and day value to draw the photo
        month_day_sum = cur_year_datas.groupby(['month', 'day']).mean().groupby(['month']).size()
        total_day = 0  # total day number
        day_value = []  # current value
        for month in months:
            total_day += month_day_sum[month]
            data_day = cur_year_datas.loc[cur_year_datas['month'] == month ]
            data_a_day = list(data_day.groupby('day')['pm2.5'].mean().values)
            day_value +=  data_a_day
        plt.plot(range(total_day), day_value, color[year-2010])
    plt.xlabel('day')
    plt.ylabel('pm2.5')
    plt.show()


def pro_see_data(df_obj):
    """
    审查数据方法
    :param df_obj:  data set
    :return:  none
    """
    # 查看数据集信息
    print('\n数据预览：')
    print(df_obj.head())
    print('\n数据统计信息：')
    print('\n数据集基本信息：')
    print(df_obj.info())


if __name__ == '__main__':
    df_obj = pd.read_csv('./pollution.csv')
    to_solve_q3(df_obj)

