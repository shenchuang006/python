--- 资源唯一标识
local key = KEYS[1]
--- 时间窗最大并发数
local limit = tonumber(ARGV[1])
--- 时间窗
local window = tonumber(ARGV[2])
--- 时间窗内当前并发数
local current = tonumber(redis.call('get', key) or "0")
if current + 1 > limit then
return 0
else
redis.call("INCRBY", key,1)
if window > -1 then
redis.call("expire", key,window)
end
end
return 1