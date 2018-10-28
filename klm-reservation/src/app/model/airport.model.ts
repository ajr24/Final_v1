export class Airport {

    code: string;
    name: string;
    parentCode: string;
    desc: string;
    
    constructor(_code: string, _name: string, _parentCode: string, _desc: string) {
        this.code = _code;
        this.name = _name;
        this.parentCode = _parentCode;
        this.desc = _desc;
    }
}