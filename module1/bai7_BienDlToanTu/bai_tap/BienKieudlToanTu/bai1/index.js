let ly;
let hoa;
let sinh;
    ly= prompt("Nhập điểm Vật Lý:");
    hoa= prompt("Nhập điểm Hóa Học:");
    sinh = prompt("Nhập điểm Sinh học:");
    let l = parseInt(ly);
    let h = parseInt(hoa);
    let s = parseInt(sinh);
    let tong = l+h+s;
    let tbc = tong/3;
    console.log("Tổng: " + tong);
    console.log("Trung bình cộng: " + tbc);


