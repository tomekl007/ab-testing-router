counter = 0

request = function()
    if counter == 10000 then
        counter = 0
    end
   path = "/route?id=" .. counter
   counter = counter + 1
   return wrk.format(nil, path)
end
