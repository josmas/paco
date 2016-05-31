//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: joda-time/src/main/java/org/joda/time/field/ScaledDurationField.java
//

#include "J2ObjC_source.h"
#include "java/lang/IllegalArgumentException.h"
#include "org/joda/time/DurationField.h"
#include "org/joda/time/DurationFieldType.h"
#include "org/joda/time/field/BaseDurationField.h"
#include "org/joda/time/field/DecoratedDurationField.h"
#include "org/joda/time/field/FieldUtils.h"
#include "org/joda/time/field/ScaledDurationField.h"

@interface OrgJodaTimeFieldScaledDurationField () {
 @public
  jint iScalar_;
}

@end

inline jlong OrgJodaTimeFieldScaledDurationField_get_serialVersionUID();
#define OrgJodaTimeFieldScaledDurationField_serialVersionUID -3205227092378684157LL
J2OBJC_STATIC_FIELD_CONSTANT(OrgJodaTimeFieldScaledDurationField, serialVersionUID, jlong)

@implementation OrgJodaTimeFieldScaledDurationField

- (instancetype)initWithOrgJodaTimeDurationField:(OrgJodaTimeDurationField *)field
                withOrgJodaTimeDurationFieldType:(OrgJodaTimeDurationFieldType *)type
                                         withInt:(jint)scalar {
  OrgJodaTimeFieldScaledDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_withInt_(self, field, type, scalar);
  return self;
}

- (jint)getValueWithLong:(jlong)duration {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getValueWithLong:duration] / iScalar_;
}

- (jlong)getValueAsLongWithLong:(jlong)duration {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getValueAsLongWithLong:duration] / iScalar_;
}

- (jint)getValueWithLong:(jlong)duration
                withLong:(jlong)instant {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getValueWithLong:duration withLong:instant] / iScalar_;
}

- (jlong)getValueAsLongWithLong:(jlong)duration
                       withLong:(jlong)instant {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getValueAsLongWithLong:duration withLong:instant] / iScalar_;
}

- (jlong)getMillisWithInt:(jint)value {
  jlong scaled = ((jlong) value) * ((jlong) iScalar_);
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getMillisWithLong:scaled];
}

- (jlong)getMillisWithLong:(jlong)value {
  jlong scaled = OrgJodaTimeFieldFieldUtils_safeMultiplyWithLong_withInt_(value, iScalar_);
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getMillisWithLong:scaled];
}

- (jlong)getMillisWithInt:(jint)value
                 withLong:(jlong)instant {
  jlong scaled = ((jlong) value) * ((jlong) iScalar_);
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getMillisWithLong:scaled withLong:instant];
}

- (jlong)getMillisWithLong:(jlong)value
                  withLong:(jlong)instant {
  jlong scaled = OrgJodaTimeFieldFieldUtils_safeMultiplyWithLong_withInt_(value, iScalar_);
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getMillisWithLong:scaled withLong:instant];
}

- (jlong)addWithLong:(jlong)instant
             withInt:(jint)value {
  jlong scaled = ((jlong) value) * ((jlong) iScalar_);
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) addWithLong:instant withLong:scaled];
}

- (jlong)addWithLong:(jlong)instant
            withLong:(jlong)value {
  jlong scaled = OrgJodaTimeFieldFieldUtils_safeMultiplyWithLong_withInt_(value, iScalar_);
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) addWithLong:instant withLong:scaled];
}

- (jint)getDifferenceWithLong:(jlong)minuendInstant
                     withLong:(jlong)subtrahendInstant {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getDifferenceWithLong:minuendInstant withLong:subtrahendInstant] / iScalar_;
}

- (jlong)getDifferenceAsLongWithLong:(jlong)minuendInstant
                            withLong:(jlong)subtrahendInstant {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getDifferenceAsLongWithLong:minuendInstant withLong:subtrahendInstant] / iScalar_;
}

- (jlong)getUnitMillis {
  return [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) getUnitMillis] * iScalar_;
}

- (jint)getScalar {
  return iScalar_;
}

- (jboolean)isEqual:(id)obj {
  if (self == obj) {
    return true;
  }
  else if ([obj isKindOfClass:[OrgJodaTimeFieldScaledDurationField class]]) {
    OrgJodaTimeFieldScaledDurationField *other = (OrgJodaTimeFieldScaledDurationField *) cast_chk(obj, [OrgJodaTimeFieldScaledDurationField class]);
    return ([((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) isEqual:[((OrgJodaTimeFieldScaledDurationField *) nil_chk(other)) getWrappedField]]) && ([self getType] == [other getType]) && (iScalar_ == other->iScalar_);
  }
  return false;
}

- (NSUInteger)hash {
  jlong scalar = iScalar_;
  jint hash_ = (jint) (scalar ^ (JreURShift64(scalar, 32)));
  hash_ += ((jint) [((OrgJodaTimeDurationFieldType *) nil_chk([self getType])) hash]);
  hash_ += ((jint) [((OrgJodaTimeDurationField *) nil_chk([self getWrappedField])) hash]);
  return hash_;
}

+ (const J2ObjcClassInfo *)__metadata {
  static const J2ObjcMethodInfo methods[] = {
    { "initWithOrgJodaTimeDurationField:withOrgJodaTimeDurationFieldType:withInt:", "ScaledDurationField", NULL, 0x1, NULL, NULL },
    { "getValueWithLong:", "getValue", "I", 0x1, NULL, NULL },
    { "getValueAsLongWithLong:", "getValueAsLong", "J", 0x1, NULL, NULL },
    { "getValueWithLong:withLong:", "getValue", "I", 0x1, NULL, NULL },
    { "getValueAsLongWithLong:withLong:", "getValueAsLong", "J", 0x1, NULL, NULL },
    { "getMillisWithInt:", "getMillis", "J", 0x1, NULL, NULL },
    { "getMillisWithLong:", "getMillis", "J", 0x1, NULL, NULL },
    { "getMillisWithInt:withLong:", "getMillis", "J", 0x1, NULL, NULL },
    { "getMillisWithLong:withLong:", "getMillis", "J", 0x1, NULL, NULL },
    { "addWithLong:withInt:", "add", "J", 0x1, NULL, NULL },
    { "addWithLong:withLong:", "add", "J", 0x1, NULL, NULL },
    { "getDifferenceWithLong:withLong:", "getDifference", "I", 0x1, NULL, NULL },
    { "getDifferenceAsLongWithLong:withLong:", "getDifferenceAsLong", "J", 0x1, NULL, NULL },
    { "getUnitMillis", NULL, "J", 0x1, NULL, NULL },
    { "getScalar", NULL, "I", 0x1, NULL, NULL },
    { "isEqual:", "equals", "Z", 0x1, NULL, NULL },
    { "hash", "hashCode", "I", 0x1, NULL, NULL },
  };
  static const J2ObjcFieldInfo fields[] = {
    { "serialVersionUID", "serialVersionUID", 0x1a, "J", NULL, NULL, .constantValue.asLong = OrgJodaTimeFieldScaledDurationField_serialVersionUID },
    { "iScalar_", NULL, 0x12, "I", NULL, NULL, .constantValue.asLong = 0 },
  };
  static const J2ObjcClassInfo _OrgJodaTimeFieldScaledDurationField = { 2, "ScaledDurationField", "org.joda.time.field", NULL, 0x1, 17, methods, 2, fields, 0, NULL, 0, NULL, NULL, NULL };
  return &_OrgJodaTimeFieldScaledDurationField;
}

@end

void OrgJodaTimeFieldScaledDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_withInt_(OrgJodaTimeFieldScaledDurationField *self, OrgJodaTimeDurationField *field, OrgJodaTimeDurationFieldType *type, jint scalar) {
  OrgJodaTimeFieldDecoratedDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_(self, field, type);
  if (scalar == 0 || scalar == 1) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_(@"The scalar must not be 0 or 1");
  }
  self->iScalar_ = scalar;
}

OrgJodaTimeFieldScaledDurationField *new_OrgJodaTimeFieldScaledDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_withInt_(OrgJodaTimeDurationField *field, OrgJodaTimeDurationFieldType *type, jint scalar) {
  OrgJodaTimeFieldScaledDurationField *self = [OrgJodaTimeFieldScaledDurationField alloc];
  OrgJodaTimeFieldScaledDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_withInt_(self, field, type, scalar);
  return self;
}

OrgJodaTimeFieldScaledDurationField *create_OrgJodaTimeFieldScaledDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_withInt_(OrgJodaTimeDurationField *field, OrgJodaTimeDurationFieldType *type, jint scalar) {
  OrgJodaTimeFieldScaledDurationField *self = [[OrgJodaTimeFieldScaledDurationField alloc] autorelease];
  OrgJodaTimeFieldScaledDurationField_initWithOrgJodaTimeDurationField_withOrgJodaTimeDurationFieldType_withInt_(self, field, type, scalar);
  return self;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(OrgJodaTimeFieldScaledDurationField)