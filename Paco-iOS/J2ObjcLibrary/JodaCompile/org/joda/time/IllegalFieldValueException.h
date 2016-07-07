//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: joda-time/src/main/java/org/joda/time/IllegalFieldValueException.java
//

#include "J2ObjC_header.h"

#pragma push_macro("OrgJodaTimeIllegalFieldValueException_INCLUDE_ALL")
#ifdef OrgJodaTimeIllegalFieldValueException_RESTRICT
#define OrgJodaTimeIllegalFieldValueException_INCLUDE_ALL 0
#else
#define OrgJodaTimeIllegalFieldValueException_INCLUDE_ALL 1
#endif
#undef OrgJodaTimeIllegalFieldValueException_RESTRICT

#if !defined (OrgJodaTimeIllegalFieldValueException_) && (OrgJodaTimeIllegalFieldValueException_INCLUDE_ALL || defined(OrgJodaTimeIllegalFieldValueException_INCLUDE))
#define OrgJodaTimeIllegalFieldValueException_

#define JavaLangIllegalArgumentException_RESTRICT 1
#define JavaLangIllegalArgumentException_INCLUDE 1
#include "java/lang/IllegalArgumentException.h"

@class OrgJodaTimeDateTimeFieldType;
@class OrgJodaTimeDurationFieldType;

@interface OrgJodaTimeIllegalFieldValueException : JavaLangIllegalArgumentException

#pragma mark Public

- (instancetype)initWithOrgJodaTimeDateTimeFieldType:(OrgJodaTimeDateTimeFieldType *)fieldType
                                        withNSNumber:(NSNumber *)value
                                        withNSNumber:(NSNumber *)lowerBound
                                        withNSNumber:(NSNumber *)upperBound;

- (instancetype)initWithOrgJodaTimeDateTimeFieldType:(OrgJodaTimeDateTimeFieldType *)fieldType
                                        withNSNumber:(NSNumber *)value
                                        withNSString:(NSString *)explain;

- (instancetype)initWithOrgJodaTimeDateTimeFieldType:(OrgJodaTimeDateTimeFieldType *)fieldType
                                        withNSString:(NSString *)value;

- (instancetype)initWithOrgJodaTimeDurationFieldType:(OrgJodaTimeDurationFieldType *)fieldType
                                        withNSNumber:(NSNumber *)value
                                        withNSNumber:(NSNumber *)lowerBound
                                        withNSNumber:(NSNumber *)upperBound;

- (instancetype)initWithOrgJodaTimeDurationFieldType:(OrgJodaTimeDurationFieldType *)fieldType
                                        withNSString:(NSString *)value;

- (instancetype)initWithNSString:(NSString *)fieldName
                    withNSNumber:(NSNumber *)value
                    withNSNumber:(NSNumber *)lowerBound
                    withNSNumber:(NSNumber *)upperBound;

- (instancetype)initWithNSString:(NSString *)fieldName
                    withNSString:(NSString *)value;

- (OrgJodaTimeDateTimeFieldType *)getDateTimeFieldType;

- (OrgJodaTimeDurationFieldType *)getDurationFieldType;

- (NSString *)getFieldName;

- (NSNumber *)getIllegalNumberValue;

- (NSString *)getIllegalStringValue;

- (NSString *)getIllegalValueAsString;

- (NSNumber *)getLowerBound;

- (NSString *)getMessage;

- (NSNumber *)getUpperBound;

- (void)prependMessageWithNSString:(NSString *)message;

@end

J2OBJC_STATIC_INIT(OrgJodaTimeIllegalFieldValueException)

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeIllegalFieldValueException *self, OrgJodaTimeDateTimeFieldType *fieldType, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeDateTimeFieldType *fieldType, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeDateTimeFieldType *fieldType, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound);

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSNumber_withNSString_(OrgJodaTimeIllegalFieldValueException *self, OrgJodaTimeDateTimeFieldType *fieldType, NSNumber *value, NSString *explain);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSNumber_withNSString_(OrgJodaTimeDateTimeFieldType *fieldType, NSNumber *value, NSString *explain) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSNumber_withNSString_(OrgJodaTimeDateTimeFieldType *fieldType, NSNumber *value, NSString *explain);

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDurationFieldType_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeIllegalFieldValueException *self, OrgJodaTimeDurationFieldType *fieldType, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDurationFieldType_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeDurationFieldType *fieldType, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDurationFieldType_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeDurationFieldType *fieldType, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound);

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithNSString_withNSNumber_withNSNumber_withNSNumber_(OrgJodaTimeIllegalFieldValueException *self, NSString *fieldName, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithNSString_withNSNumber_withNSNumber_withNSNumber_(NSString *fieldName, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithNSString_withNSNumber_withNSNumber_withNSNumber_(NSString *fieldName, NSNumber *value, NSNumber *lowerBound, NSNumber *upperBound);

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSString_(OrgJodaTimeIllegalFieldValueException *self, OrgJodaTimeDateTimeFieldType *fieldType, NSString *value);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSString_(OrgJodaTimeDateTimeFieldType *fieldType, NSString *value) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDateTimeFieldType_withNSString_(OrgJodaTimeDateTimeFieldType *fieldType, NSString *value);

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDurationFieldType_withNSString_(OrgJodaTimeIllegalFieldValueException *self, OrgJodaTimeDurationFieldType *fieldType, NSString *value);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDurationFieldType_withNSString_(OrgJodaTimeDurationFieldType *fieldType, NSString *value) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithOrgJodaTimeDurationFieldType_withNSString_(OrgJodaTimeDurationFieldType *fieldType, NSString *value);

FOUNDATION_EXPORT void OrgJodaTimeIllegalFieldValueException_initWithNSString_withNSString_(OrgJodaTimeIllegalFieldValueException *self, NSString *fieldName, NSString *value);

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *new_OrgJodaTimeIllegalFieldValueException_initWithNSString_withNSString_(NSString *fieldName, NSString *value) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT OrgJodaTimeIllegalFieldValueException *create_OrgJodaTimeIllegalFieldValueException_initWithNSString_withNSString_(NSString *fieldName, NSString *value);

J2OBJC_TYPE_LITERAL_HEADER(OrgJodaTimeIllegalFieldValueException)

#endif

#pragma pop_macro("OrgJodaTimeIllegalFieldValueException_INCLUDE_ALL")