function solution(n, works) {
    // 1. 내림차순 정렬
    works.sort((a, b) => b - a);

    while (n > 0) {
        if (works[0] === 0) break;

        // 가장 큰 작업 줄이기
        works[0] -= 1;

        // 위치 재정렬 (앞에서부터 한 칸씩 내리기)
        let i = 0;
        while (i + 1 < works.length && works[i] < works[i + 1]) {
            // swap
            [works[i], works[i + 1]] = [works[i + 1], works[i]];
            i++;
        }

        n--;
    }

    return works.reduce((sum, w) => sum + w * w, 0);
}
