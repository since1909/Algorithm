def solution(cacheSize, cities):
    answer = 0
    cache = []
    for city in cities:
        if cache.count(city.lower()) == 0:
            if len(cache) < cacheSize : 
                cache.append(city.lower())

            else:
                if len(cache) != 0:
                    cache.pop(0)
                    cache.append(city.lower())
            answer += 5
        else:
            cache.remove(city.lower())
            cache.append(city.lower())
            answer += 1
    return answer