/* 1. 필요한 피자 판 수 = (필요한 총 조각 수) / (한 판의 조각 수)
   2. 올림 계산을 통해 -1 작업 필요
   3. (n + slice -1) / slice
   4. 몫만 사용
*/
class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        answer = (n + slice -1) / slice;
        return answer;
    }
}