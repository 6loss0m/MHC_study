# 17683 - 방금그곡
# 제목, 재생 시간, 악보
# 음은 1분에 1개씩 재생
# musicinfos = [시작 시각, 끝난 시각, 음악 제목, 악보 정보]

def solution(m, musicinfos):
    answer = []
    m = m.replace('A#', 'H').replace('C#', 'I').replace('D#', 'J').replace('F#', 'K').replace('G#', 'L') # #이 들어간 음은 HIJKL로 변환한다.

    for musicinfo in musicinfos:
        musicinfo = musicinfo.split(',') # ,를 기준으로 나눈다.
        musicinfo[3] = musicinfo[3].replace('A#', 'H').replace('C#', 'I').replace('D#', 'J').replace('F#', 'K').replace('G#', 'L') # 마찬가지로 악보 정보인 musicinfo[3]에서 #이 들어간 음은 모두 HIJKL로 변환

        time = (int(musicinfo[1].split(':')[0]) * 60 + int(musicinfo[1].split(':')[1])) - (
                int(musicinfo[0].split(':')[0]) * 60 + int(musicinfo[0].split(':')[1]))
        # 이전에 버스시간 문제처럼! 모두 분으로 바꾼 다음, 시작 시각과 끝난 시각을 빼서 재생시간을 구한다.

        music = ''.join(musicinfo[3] * (time // len(musicinfo[3])) + musicinfo[3][:time % len(musicinfo[3])])
        # 총 재생시간을 악보정보의 길이로 나눈 몫만큼 곱하여 정보를 늘여놓고,
        # print(music)
        # 총 재생시간을 악보정보의 길이로 나눈 나머지만큼 붙인다.
        # ex) 예제 1의 경우 나머지가 따로 붙지않으므로 CDEFGABCDEFGAB
        # ABCDE 가 music에 저장된다.

        if m in music: # m이 music에 포함되어 있다면 정답후보 이므로 answer에 추가
            answer.append((time, musicinfo[2])) # 재생시간, 노래 제목을 answer에 추가

    if len(answer) > 0: # answer에 추가된 요소의 개수가 0보다 크다면 (정답 후보가 있다면)
        answer.sort(key=lambda x: -x[0]) # sort, 재생된 시간이 제일 긴 음악 제목을 반환해야하므로
        return answer[0][1] # 위에서 구한 값을 return

    return "(None)" # 조건에 맞는 음악이 없는 경우 None 반환
    