package com.ssafy.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
10
1 1 4
2 1 6
3 6 10
4 5 7
5 3 8
6 5 9
7 3 5
8 8 11
9 2 13
10 12 14
 */

public class MeetingRoomTest {
	
	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no,start,end;

		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}
		
		// (1,1,2) (2,2,3) (3,3,3)
		// (1,1,2) (3,3,3) (2,3,3)
		// 즉 시작시간과 종료시간이 같은 입력이 있을 수 있음
		// 따라서 종료시간이 같다면 시작시간이 빠른 순서대로 정렬
		@Override
		public int compareTo(MeetingRoom o) {
			int diff = this.end - o.end;
			return diff !=0 ? diff : this.start - o.start; 
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MeetingRoom [no=").append(no).append(", start=").append(start).append(", end=").append(end)
					.append("]");
			return builder.toString();
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		MeetingRoom[] m = new MeetingRoom[N];
		
		for (int i = 0; i < N; i++) {
			m[i] = new MeetingRoom(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		List<MeetingRoom> list = getSchedule(m);
		for(MeetingRoom meetingRoom : list) { // 배정된 회의출력
			System.out.println(meetingRoom);
		}

	}
	
	public static List<MeetingRoom> getSchedule(MeetingRoom[] m){
		ArrayList<MeetingRoom> list = new ArrayList<MeetingRoom>(); // 배정된 회의들이 리스트에 담김
		
		Arrays.sort(m);
		list.add(m[0]); // 첫 회의는 무조건 배정
		for (int i = 1,size=m.length; i < size; i++) { 
			// 리스트 안에 저장된 회의의 가장 마지막 회의의 종료시간과 다음 회의의 시작시간 비교
			if(list.get(list.size()-1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
		return list;
	}

}
