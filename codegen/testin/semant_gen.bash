
EXT=cl
for i in *; do
    if [ "${i}" != "${i%.${EXT}}" ];then
        /usr/class/cs143/bin/coolc -k ${i}
        filename="${i%.*}"
		mv semant.out ${filename}.semant
    fi
done