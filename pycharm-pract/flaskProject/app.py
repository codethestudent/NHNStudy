from flask import Flask
from influxdb_client import InfluxDBClient
import pymysql
from datetime import datetime, timedelta
import random  # 예측 모델 대신 임시로 사용

app = Flask(__name__)

# InfluxDB 설정
influxdb_url = 'http://133.186.223.19:8086'
influxdb_token = 'YcnVLCaDkDWyGS78u3dRutWqirmc6424MHnqZl7N6adaoDjfwnbP_GzFpqTkYmjI5LFc0aRcT1F-_I09SYF4Vw=='
influxdb_org = 'ioteatime'
influxdb_bucket = 'ioteatime'

mysql_config = {
    'host': '133.186.244.96',
    'user': 'nhn_academy_37',
    'password': 'xo-5vMk2*gQpu*f1',
    'db': 'nhn_academy_37',
    'charset': 'utf8',
    'cursorclass': pymysql.cursors.DictCursor
}



def fetch_timeseries_data():
    """InfluxDB에서 타임시리즈 데이터를 가져오는 함수"""
    client = InfluxDBClient(url=influxdb_url, token=influxdb_token, org=influxdb_org)
    query = ('from(bucket:"ioteatime") |> range(start: -1h) |> filter(fn: '
             '(r) => r["place"] == "class_a") |> filter(fn: (r) => r["type"] == "system") |> filter(fn: (r) => r['
             '"description"] == "frequency") |> aggregateWindow(every: 1m, fn: last, createEmpty: '
             'false) |> yield(name: "last")')
    result = client.query_api().query(query, org=influxdb_org)
    # 결과 처리 및 반환
    # 이 부분은 실제 데이터와 쿼리에 따라 달라질 수 있음
    data_points = []
    for table in result:
        for record in table.records:
            data_points.append((record.get_time(), record.get_value()))
    return data_points

def predict_future_value():
    """미래 값 예측하는 함수 - 예시로 랜덤 값 반환"""
    return random.random()


def save_prediction_to_mysql(prediction):
    """예측 값을 MySQL에 저장하는 함수"""
    # pymysql을 사용하여 MySQL 데이터베이스 연결
    conn = pymysql.connect(**mysql_config)
    try:
        with conn.cursor() as cursor:
            # 삽입할 데이터를 가진 SQL 쿼리
            query = ("INSERT INTO predictions (prediction_date, value) VALUES (%s, %s)")
            data = (datetime.now() + timedelta(days=1), prediction)
            cursor.execute(query, data)
            # 변경사항 커밋
            conn.commit()
    finally:
        conn.close()


@app.route('/predict-and-save')
def predict_and_save():
    # InfluxDB에서 데이터 가져오기 (실제 환경에서는 이 데이터를 사용하여 예측 수행)
    timeseries_data = fetch_timeseries_data()
    for time, value in timeseries_data:
        print(f"Time: {time}, Value: {value}")
    # 미래 값 예측
    # future_value = predict_future_value()
    # 예측한 값을 MySQL에 저장
    # save_prediction_to_mysql(future_value)
    return timeseries_data;


if __name__ == '__main__':
    app.run()
