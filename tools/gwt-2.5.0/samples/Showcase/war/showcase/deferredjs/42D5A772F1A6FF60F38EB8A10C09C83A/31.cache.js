function Bwb(a){this.a=a}
function Mvb(){this.a=new Kxc}
function ywb(a,b){this.a=a;this.b=b}
function uwb(b){var a,c,d;d=Eqc(gr(b.a.cb,LIc));if(rqc(d,HCc)){wac(b.c,'<entrer un nom de m\xE9thode, s\u2019il vous pla\xEEt>')}else{try{c=Lvb(b.b,d);wac(b.c,c)}catch(a){a=Fdb(a);if(rU(a,162)){wac(b.c,'<Pas de r\xE9sultats trouv\xE9s>')}else throw a}}}
function twb(a){var b,c,d,e,f;a.b=new Mvb;c=new h5b;b=pU(c.j,100);c.o[VGc]=5;f=Qgb(V1);d=new UZb(f);jj(d,new ywb(a,f),(jx(),jx(),ix));e=new Z6b;e.e[VGc]=3;W6b(e,new G2b(VLc));W6b(e,d);b5b(c,0,0,e);q5b(b,0)[KIc]=2;a.a=new Gac;wac(a.a,TJc);Ti(a.a,ILc);$4b(c,1,0,'<b>Nom de la m\xE9thode:<\/b>');b5b(c,1,1,a.a);a.c=new Gac;LZb(a.c,false);Ti(a.c,ILc);$4b(c,2,0,'<b>R\xE9sultats du Lookup:<\/b>');b5b(c,2,1,a.c);jj(a.a,new Bwb(a),(Vx(),Vx(),Ux));uwb(a);return c}
function Lvb(a,b){var c;c=pU(a.a.ie(b),1);if(c!=null){return c}if(rqc(b,SJc)){a.a.ke(SJc,bMc);return bMc}if(rqc(b,XJc)){a.a.ke(XJc,cMc);return cMc}if(rqc(b,VJc)){a.a.ke(VJc,dMc);return dMc}if(rqc(b,YLc)){a.a.ke(YLc,eMc);return eMc}if(rqc(b,ZLc)){a.a.ke(ZLc,fMc);return fMc}if(rqc(b,TJc)){a.a.ke(TJc,$Lc);return $Lc}if(rqc(b,QJc)){a.a.ke(QJc,_Lc);return _Lc}if(rqc(b,WJc)){a.a.ke(WJc,aMc);return aMc}throw new Lyc("Cannot find constant '"+b+"'; expecting a method name")}
zeb(645,1,{},Mvb);zeb(656,1,YAc,ywb);_.Dc=function zwb(a){Jgb(this.a,this.b+TLc)};_.a=null;_.b=null;zeb(657,1,JAc,Bwb);_.Fc=function Cwb(a){uwb(this.a)};_.a=null;zeb(658,1,_Ac);_.lc=function Gwb(){hhb(this.b,twb(this.a))};var V1=rpc(THc,'ColorConstants'),d2=ppc(THc,'CwConstantsWithLookupExample$1',656),e2=ppc(THc,'CwConstantsWithLookupExample$2',657),U1=ppc(THc,'ColorConstants_fr',645);OBc(vn)(31);