
# git 

## Quan Trọng

1. **không** push code trực tiếp vào branch **main**
3. **ưu tiên** merge bằng **github pull request**

## quy ước tên branch

tên người code/tên chức năng
> ví dụ thinh/promotion

## quy trình làm việc

1. checkout branch

> git checkout -b your-branch
>
> sẽ tạo branch mới từ branch hiện tại

```shell
  git checkout your-branch
```

2. pull (rebase) code từ branch chính

> branch chính thường sẽ là main
>
> những trường hợp **đặc biệt sẽ được nói đến sau**
```shell
  git pull --rebase origin main-branch
```

3. coding ...

5. thêm files vào git index

> git add .
>
> nếu muốn add tất cả files trong folder hiện tại (recursive)
``` shell
  git add path
```

7. commit changes

```shell
  git commit -m "something"
```

8. push to git remote

+ **đảm bảo đóng branch trc khi push**
+ **nếu sai branch, vẫn có cách giải quyết ^^**
``` shell
  git push origin
```
