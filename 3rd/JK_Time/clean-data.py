import numpy as np
import pandas as pd

# 你在读取数据的时候，添加列索引
names=['first_name', 'last_name', 'age', 'weight', 'four', 'five', 'six', 'seven', 'eight', 'nine']
df = pd.read_excel('./data.xlsx', names=names)
# 除去全部为空的数据
df.dropna(how='all', inplace=True)
# 使用均值填充NaN
# df['age'].fillna(round(df['age'].mean(), 0), inplace=True)
# 使用频率最高填充NaN, 出现值的次数
age_maxf = df['age'].value_counts().index[0]  # 取第一个值
df['age'].fillna(age_maxf, inplace=True)
weight_maxf = df['weight'].value_counts().index[0]  # 取第一个值
df['weight'].fillna(weight_maxf, inplace=True)
# 获取weight数据中单位为ibs的数据
rows_with_ibs = df['weight'].str.contains('Ibs')  # contains 检查str中是否包含某个字符,有返回true，反之
# 将Ibs装换成kgs， 2.21Ibs = 1kgs
for i, ibs_row in df[rows_with_ibs].iterrows():  # 可以考虑为遍历
    # 截取从头到第三个字符，去掉Ibs
    weight = int(float(ibs_row['weight'][:-3])/2.2)
    df.at[i, 'weight'] = '{}kgs'.format(weight)
# 删除非 ASCII 字符
df['first_name'].replace({r'[^\x00-\x7F]+':''}, regex=True, inplace=True)
df['last_name'].replace({r'[^\x00-\x7F]+':''}, regex=True, inplace=True)
# 删除重复数据行
df.drop_duplicates(['first_name','last_name'],inplace=True)


print(df)

